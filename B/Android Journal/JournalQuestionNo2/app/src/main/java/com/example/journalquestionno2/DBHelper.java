package com.example.journalquestionno2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String Table_Name = "Employee";

    public static final String Column_1 = "ID";
    public static final String Column_2 = "NAME";
    public static final String Column_3 = "DEPARTMENT";
    public static final String Column_4 = "SALARY";


    public DBHelper (Context context) {
        super(context, "Employee.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Table
        db.execSQL("CREATE TABLE " + Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DEPARTMENT TEXT, SALARY REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS "+ Table_Name);
        onCreate(db);
    }

    // Method to insert data into the table
    public boolean insertData(int eid, String ename, String adept, double esalary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_1, eid);
        contentValues.put(Column_2, ename);
        contentValues.put(Column_3, adept);
        contentValues.put(Column_4, esalary);

        long result = db.insert(Table_Name, null, contentValues);
        return result != -1;
    }
}
