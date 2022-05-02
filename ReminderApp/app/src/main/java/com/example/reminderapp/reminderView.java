package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class reminderView extends AppCompatActivity {

    RecyclerView reminderView;
    FloatingActionButton addReminder;

    ArrayList<String> rDates, rTitles, rNotes;
    reminderDB reminderDB;
    reminderAdapter reminderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_view);

        reminderView=findViewById(R.id.reminderView);
        addReminder=findViewById(R.id.addReminder);

        addReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(reminderView.this, AddReminder.class);
                startActivity(intent);
            }
        });
        reminderDB=new reminderDB(reminderView.this);
        rDates=new ArrayList<>();
        rTitles=new ArrayList<>();
        rNotes=new ArrayList<>();
        storeData();
        reminderAdapter=new reminderAdapter(reminderView.this, rDates, rTitles, rNotes);
        reminderView.setAdapter(reminderAdapter);
        reminderView.setLayoutManager(new LinearLayoutManager(reminderView.this));
    }

    public void storeData() {
        Cursor cursor = reminderDB.readDatabase();
        while(cursor.moveToNext()) {
            rDates.add(cursor.getString(0));
            rTitles.add(cursor.getString(1));
            rNotes.add(cursor.getString(2));
        }

    }
}