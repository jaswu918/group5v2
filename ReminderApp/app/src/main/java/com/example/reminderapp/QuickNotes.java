package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class QuickNotes extends AppCompatActivity {
    //button settings to access settings page
    FloatingActionButton addButton;
    RecyclerView qnView;
    ArrayList<String> theDate, qNotes;
    database db;
    recycleAdapter rAdapter;

    //button to go back to homepage
    Button backToHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_notes);

        addButton = findViewById(R.id.addButton);
        qnView = findViewById(R.id.qnView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuickNotes.this, addQuickNotes.class);
                startActivity(intent);
            }
        });
        db = new database(QuickNotes.this);
        theDate = new ArrayList<>();
        qNotes = new ArrayList<>();
        storeData();  //this crashes the app
        rAdapter = new recycleAdapter(QuickNotes.this, theDate, qNotes);
        qnView.setAdapter(rAdapter);
        qnView.setLayoutManager(new LinearLayoutManager(QuickNotes.this));

        backToHP = (Button) findViewById(R.id.QNBack);
        backToHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHP();
            }
        });
    }

    public void storeData() {
        Cursor cursor = db.readDatabase();
        while (cursor.moveToNext()) {
            theDate.add(cursor.getString(0));
            qNotes.add(cursor.getString(1));
        }

    }

    public void toHP() {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }
}