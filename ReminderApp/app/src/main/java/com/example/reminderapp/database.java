package com.example.reminderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    private Context context;
    public static String DATABASE = "QuickNotes.db";

    public static String TABLE_NAME = "qn_view";
    public static String QUICK_NOTES = "quick_notes";
    public static String DATE = "month_day_year";

    public database(@Nullable Context context) {
        super(context, DATABASE, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + DATE + " TEXT, " + QUICK_NOTES + " TEXT);";
        sqLiteDatabase.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Add code....
    }

    public void addNotes(String date, String quickNotes) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATE, date);
        contentValues.put(QUICK_NOTES, quickNotes);
        long added = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (added == -1) {
            Toast.makeText(context, "Nothing Added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readDatabase() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = null;
        if (sqLiteDatabase != null) {
            cursor = sqLiteDatabase.rawQuery(query, (String[]) null);
        }
        return cursor;
    }
}
