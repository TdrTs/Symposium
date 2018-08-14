package com.storedataroom.tudor.storedataroom;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "peopleS.db";
    public static final String TABLE_NAME = "peopleS_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRSTNAME";
    public static final String COL_3 = "LASTNAME";
    public static final String COL_4 = "ADRESS";
    public static final String COL_5 = "CITY";
    public static final String COL_6 = "COUNTRY";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, LASTNAME TEXT, ADRESS TEXT, CITY TEXT, COUNTRY TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    public boolean insertData(String name, String surname, String adress, String city, String country) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, adress);
        contentValues.put(COL_5, city);
        contentValues.put(COL_6, country);


        long result = db.insert(TABLE_NAME, null, contentValues);

        Log.d("myTag1", String.valueOf(result));

        if (result == -1) {
            return  false;
        } else {
            return  true;
        }
    }


}
