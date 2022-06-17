package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATA_NAME = "Database.db";
    public static final String TABLE_NAME = "user";
    public static final String Col_1 = "ID";
    public static final String Col_2 = "Name";
    public static final String Col_3 = "Password";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATA_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT , Name TEXT ,Password TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);

    }
    public boolean  insertData(String name,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2,name);
        contentValues.put(Col_3,password);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result==-1)
        {
            return false;
        }
        else
        {
            return true ;
        }
    }
}
