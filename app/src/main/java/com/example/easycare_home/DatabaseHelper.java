package com.example.easycare_home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper (Context context){
        super(context, "Login db", null, 1);
    }

    public void onCreate (SQLiteDatabase db){
        db.execSQL("Create table user (username text primary key, username text, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");

    }
    public Boolean insert (String username, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if (ins == 1) return false;
        else return true;

    }
    public Boolean chkemail (String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email =?", new String[]{email});
        if (cursor.getCount() > 0) return false;
        else return true;
    }
    public Boolean usernamepassword (String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username =? and password =?", new String[]{username, password});
        if (cursor.getCount() > 0) return false;
        else return true;
    }
}
