package com.example.reminderapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChangeCode extends AppCompatActivity {

    //buttons b#, # represents the number on the passcode keypad, clearB is the clear button, submitB is the submit button
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, clearB, submitB;
    //display the input as a TextView
    private TextView input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_code);

        //id inputCode2 is the display TextView
        input = (TextView) findViewById(R.id.inputCode2);

        //id c0....c9 is the code number inputs
        b1 = (Button) findViewById(R.id.c1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "1");
            }
        });

        b2 = (Button) findViewById(R.id.c2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "2");
            }
        });

        b3 = (Button) findViewById(R.id.c3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "3");
            }
        });

        b4 = (Button) findViewById(R.id.c4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "4");
            }
        });

        b5 = (Button) findViewById(R.id.c5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "5");
            }
        });

        b6 = (Button) findViewById(R.id.c6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "6");
            }
        });

        b7 = (Button) findViewById(R.id.c7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "7");
            }
        });

        b8 = (Button) findViewById(R.id.c8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "8");
            }
        });

        b9 = (Button) findViewById(R.id.c9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "9");
            }
        });

        b0 = (Button) findViewById(R.id.c0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "0");
            }
        });

        clearB = (Button) findViewById(R.id.clearButton2);
        clearB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
            }
        });

        submitB = (Button) findViewById(R.id.submitB2);
        submitB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMA();
            }
        });
    }

    //open the Main Activity/lock screen
    public void openMA() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("NewPass", input.getText().toString());
        startActivity(intent);
    }

}