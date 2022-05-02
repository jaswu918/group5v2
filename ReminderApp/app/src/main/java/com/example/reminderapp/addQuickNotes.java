package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addQuickNotes extends AppCompatActivity {

    EditText textNotes, dateText;
    Button addQN;
    database db = new database(addQuickNotes.this);
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quick_notes);

        textNotes = findViewById(R.id.textNotes);
        dateText = findViewById(R.id.dateText);
        addQN = findViewById(R.id.addQN);

        addQN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.addNotes(dateText.getText().toString(), textNotes.getText().toString());
            }
        });
    }
}