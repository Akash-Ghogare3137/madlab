package com.example.journalquestionno2;

import android.os.Bundle;
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

    EditText empId, empName, empDept, empSal;
    Button InsertButton;

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

        empId = findViewById(R.id.etxt_eid);
        empName = findViewById(R.id.etxt_ename);
        empDept = findViewById(R.id.etxt_adept);
        empSal = findViewById(R.id.etxt_esalary);
        InsertButton = findViewById(R.id.btn_insertButton);

        InsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int ID = Integer.parseInt(empId.getText().toString());
                String Name = empName.getText().toString();
                String Dept = empDept.getText().toString();
                double Sal = Double.parseDouble(empSal.getText().toString());

                DBHelper db = new DBHelper(MainActivity.this);
                boolean result = db.insertData(ID, Name, Dept, Sal);

                if (result){
                    Toast.makeText(MainActivity.this,"Record Inserted Successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Error Occurred!!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}