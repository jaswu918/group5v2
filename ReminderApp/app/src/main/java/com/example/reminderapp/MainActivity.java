package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Main Activity is the lock screen page
public class MainActivity extends AppCompatActivity {
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, clearB, submitB;
    private TextView input;
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            password = extras.getString("NewPass");
        } else {
            password = "";
        }

        input = (TextView) findViewById(R.id.inputCode);

        b1 = (Button) findViewById(R.id.num1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "1");
            }
        });

        b2 = (Button) findViewById(R.id.num2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "2");
            }
        });

        b3 = (Button) findViewById(R.id.num3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "3");
            }
        });

        b4 = (Button) findViewById(R.id.num4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "4");
            }
        });

        b5 = (Button) findViewById(R.id.num5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "5");
            }
        });

        b6 = (Button) findViewById(R.id.num6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "6");
            }
        });

        b7 = (Button) findViewById(R.id.num7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "7");
            }
        });

        b8 = (Button) findViewById(R.id.num8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "8");
            }
        });

        b9 = (Button) findViewById(R.id.num9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "9");
            }
        });

        b0 = (Button) findViewById(R.id.num0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "0");
            }
        });

        clearB = (Button) findViewById(R.id.clearButton);
        clearB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
            }
        });

        submitB = (Button) findViewById(R.id.submitB);
        submitB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().equals(password)) {
                    openHP();
                }
            }
        });
    }

    public void openHP() {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

}