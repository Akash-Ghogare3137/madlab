package com.example.journalquestionno3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText studentName, courseName;
    Button insertButton;
    TextView displayText;
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

        studentName = findViewById(R.id.etxt_studentName);
        courseName = findViewById(R.id.etxt_courseName);
        insertButton = findViewById(R.id.btn_insert);
        displayText = findViewById(R.id.txt_displayText);

        // Create or Open a SQLite Database
        db = openOrCreateDatabase("StudentDB", MODE_PRIVATE, null);

        // Create a Student Table
        db.execSQL("CREATE TABLE IF NOT EXISTS Student (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, course VARCHAR);");

        insertButton.setOnClickListener(v -> {

            String Name = studentName.getText().toString();
            String Course = courseName.getText().toString();

            // Insert the record into the database
            db.execSQL("INSERT INTO Student(name,course) VALUES ('"+Name+"','"+Course+"');");

            // Using Cursor to query and display the inserted data
            Cursor cursor = db.rawQuery("SELECT * FROM Student",null);
            StringBuilder stringBuilder = new StringBuilder();

            // Move Cursor to the first row
            if (cursor.moveToFirst()){

                do {
                    // Get the column values
                    int id = cursor.getInt(0);
                    String studentName = cursor.getString(1);
                    String courseName = cursor.getString(2);

                    // Append the data to the stringBuilder
                    stringBuilder.append("ID : ").append(id).append(", Name : ").append(studentName).append(", Course : ").append(courseName).append("\n");

                }while (cursor.moveToNext());
            }

            cursor.close();

            // displaying the data in the textview
            displayText.setText(stringBuilder.toString());
        });
    }
}