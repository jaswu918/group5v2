package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {
    Button settings, toQuickNotes, toAddReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        toQuickNotes = findViewById(R.id.toQuickNotes);
        settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettings();
            }
        });
        toQuickNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homepage.this, QuickNotes.class);
                startActivity(intent);
            }
        });

        toAddReminder = findViewById(R.id.toAddReminder);
        toAddReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addReminder();
            }
        });
    }

    public void openSettings() {
        Intent intent = new Intent(Homepage.this, Settings.class);
        startActivity(intent);
    }

    public void addReminder() {
        Intent intent = new Intent(Homepage.this, reminderView.class);
        startActivity(intent);
    }
}