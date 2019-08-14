package com.venom.assignment.contact.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static com.venom.assignment.contact.model.Constants.COLUMN_TIMESTAMP;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "test1234_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Constants.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public void insert(Message message) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Constants.name, message.getName());
        values.put(Constants.otp, message.getOtp());

        // insert row
        db.insert(Constants.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
    }


    public List<Message> getAll() {
        List<Message> mList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Constants.TABLE_NAME + " ORDER BY " +
                COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                mList.add(new Message(
                        cursor.getString(cursor.getColumnIndex(Constants.name)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_TIMESTAMP)),
                        cursor.getString(cursor.getColumnIndex(Constants.otp))
                ));
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return mList;
    }
}