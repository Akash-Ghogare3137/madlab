package com.example.journalquestionno5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context,"UserDB.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE User(id INTEGER PRIMARY KEY AUTOINCREMENT," + "firstName TEXT NOT NULL," + "lastName TEXT NOT NULL," + "mobileNumber TEXT NOT NULL," + "email TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);
    }
}
