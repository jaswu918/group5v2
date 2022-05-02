package com.example.reminderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class reminderDB extends SQLiteOpenHelper {

    Context context;
    private static String DATABASE="Reminder.db";

    private static String TABLE_NAME="reminders";
    private static String REMINDER_DATE="date";
    private static String REMINDER_TITLE="title";
    private static String REMINDER_NOTE="note";

    public reminderDB(@Nullable Context context) {
        super(context, DATABASE, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable="CREATE TABLE " + TABLE_NAME + " (" + REMINDER_DATE + " TEXT, " + REMINDER_TITLE + " TEXT, " + REMINDER_NOTE + " TEXT);";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addReminder(String date, String title, String note){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(REMINDER_DATE, date);
        contentValues.put(REMINDER_TITLE, title);
        contentValues.put(REMINDER_NOTE, note);
        long added= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(added ==-1) {
            Toast.makeText(context, "Nothing Added", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
        }
    }
    public Cursor readDatabase() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor=null;
        if (sqLiteDatabase != null) {
            cursor = sqLiteDatabase.rawQuery(query, (String[])null);
        }
        return cursor;
    }
}
