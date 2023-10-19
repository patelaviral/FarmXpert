package com.example.agriculture;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database1 extends SQLiteOpenHelper {
    public database1(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String acc = "create table users(username text, password text, number text)";
        sqLiteDatabase.execSQL(acc);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void register(String username, String password){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("Password",password);
        //cv.put("Phone number",number);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }
    public int login(String username, String password){
        int result = 0;
        String [] arr = new String[2];
        arr[0] = username;
        arr[1] = password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where username=? and password=?",arr);
        if(c.moveToFirst()){                           // moveToFirst check kerna hoga
            result = 1;
        }
        return result;
    }
}
