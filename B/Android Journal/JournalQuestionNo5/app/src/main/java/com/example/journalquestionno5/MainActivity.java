package com.example.journalquestionno5;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText firstName, lastName, mobileNumber, email;
    Button submit;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstName = findViewById(R.id.firstNameEditText);
        lastName = findViewById(R.id.lastNameEditText);
        mobileNumber = findViewById(R.id.mobileNumberEditText);
        email = findViewById(R.id.emailEditText);

        submit = findViewById(R.id.submitButton);

        // Initializing db
        SQLiteOpenHelper dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()){
                    saveUserData();
                }
            }
        });
    }
    private boolean validateInput() {
        if(TextUtils.isEmpty(firstName.getText())){
            firstName.setError("First Name is Required");
            return false;
        }
        if (TextUtils.isEmpty(lastName.getText())) {
            lastName.setError("Last name is required");
            return false;
        }

        if (TextUtils.isEmpty(mobileNumber.getText()) || !Patterns.PHONE.matcher(mobileNumber.getText()).matches()) {
            mobileNumber.setError("Valid mobile number is required");
            return false;
        }

        if (TextUtils.isEmpty(email.getText()) || !Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()) {
            email.setError("Valid email is required");
            return false;
        }

        return true;
    }

    private void saveUserData() {

        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName",firstName.getText().toString());
        contentValues.put("lastName",lastName.getText().toString());
        contentValues.put("mobileNumber",mobileNumber.getText().toString());
        contentValues.put("email",email.getText().toString());

        long newRowId = db.insert("User", null, contentValues);

        if(newRowId != -1){
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
            clearFields();
        }else {
            Toast.makeText(this,"Error Saving Data!", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        firstName.setText("");
        lastName.setText("");
        mobileNumber.setText("");
        email.setText("");

    }
}