package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {
    private Button changeCode, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        changeCode = (Button) findViewById(R.id.changeCode);
        changeCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChangeCode();
            }
        });

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHP();
            }
        });
    }

    public void openChangeCode() {
        Intent intent = new Intent(this, ChangeCode.class);
        startActivity(intent);
    }

    public void toHP() {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }
}