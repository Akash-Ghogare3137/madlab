package com.example.journalquestionno11;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button alertDialogButton, datePickerDialogButton, timePickerDialogButton, progressDialogButton;

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

        // Initialize buttons
        alertDialogButton = findViewById(R.id.alertDialogButton);
        datePickerDialogButton = findViewById(R.id.datePickerDialogButton);
        timePickerDialogButton = findViewById(R.id.timePickerDialogButton);
        progressDialogButton = findViewById(R.id.progressDialogButton);

        // Set click listeners for the buttons

        // Alert Dialog
        alertDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        // Date Picker Dialog
        datePickerDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // Time Picker Dialog
        timePickerDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        // Progress Dialog
        progressDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
            }
        });
    }

    // Method to show an AlertDialog
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("This is an Alert Dialog. Do you want to proceed?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "You clicked Yes", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("No", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "You clicked No", Toast.LENGTH_SHORT).show();
        });
        builder.setNeutralButton("Cancel", (dialog, which) -> {
            dialog.dismiss();
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // Method to show a DatePickerDialog
    private void showDatePickerDialog() {
        // Get the current date
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Toast.makeText(MainActivity.this, "Selected Date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year, Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    // Method to show a TimePickerDialog
    private void showTimePickerDialog() {
        // Get the current time
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Create a TimePickerDialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(MainActivity.this, "Selected Time: " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                    }
                }, hour, minute, true);
        timePickerDialog.show();
    }

    // Method to show a ProgressDialog
    private void showProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Progress Dialog");
        progressDialog.setMessage("Loading, please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        // Dismiss the dialog after 3 seconds (for demonstration purposes)
        new android.os.Handler().postDelayed(() -> progressDialog.dismiss(), 3000);
    }
}