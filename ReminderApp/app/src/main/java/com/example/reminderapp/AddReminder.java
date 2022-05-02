package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddReminder extends AppCompatActivity {

    EditText dateAndTimeInput, title_input, desc_input;
    Button setReminder, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        notificationChannel();

        setReminder = findViewById(R.id.setReminder);
        title_input=findViewById(R.id.title_input);
        desc_input=findViewById(R.id.desc_input);
        dateAndTimeInput = findViewById(R.id.date_time_input);
        dateAndTimeInput.setInputType(InputType.TYPE_NULL);
        dateAndTimeInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateTimeDialog(dateAndTimeInput);
            }
        });

        setReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reminderDB reminderDB = new reminderDB(AddReminder.this);
                reminderDB.addReminder(dateAndTimeInput.getText().toString(), title_input.getText().toString(), desc_input.getText().toString());
                if (dateAndTimeInput.getText().length() == 0) {
                    //do nothing
                } else {
                    setNotification();
                }
                Intent intent = new Intent(AddReminder.this, reminderView.class);
                startActivity(intent);
            }
        });

        back = findViewById(R.id.addReminderBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHomepage();
            }
        });
    }

    private void showDateTimeDialog(final EditText date_time_in) {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm");

                        date_time_in.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };

                new TimePickerDialog(AddReminder.this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
            }
        };

        new DatePickerDialog(AddReminder.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void notificationChannel() {  //This wont affect our app for our SDK version. This is for other users with different versions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = ("Notification");
            String description = "For Reminders";
            NotificationChannel channel = new NotificationChannel("Noti", "CISC3171", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public long getTime(int year, int month, int date, int hourOfDay, int minute, int second) {
        Calendar setTimer = Calendar.getInstance();
        setTimer.set(year, month, date, hourOfDay, minute, second);
        long time = setTimer.getTimeInMillis();
        return time;
    }

    public void setNotification() {
        String input = dateAndTimeInput.getText().toString();
        long timer = getTime(getYear(input), getMonth(input) - 1, getDay(input), getHour(input), getMinute(input), 0);
        long cutoff = 1649504340713L;
        if (timer < cutoff) {   //Any time that passed wont set reminder.
            Toast.makeText(AddReminder.this, "Reminder Not Set. Date Already Passed!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(AddReminder.this, "Reminder Set!", Toast.LENGTH_SHORT).show();
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            Intent intent = new Intent(AddReminder.this, receiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(AddReminder.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, timer, pendingIntent);
        }
    }

    public void setNotification(long timer) {
        long b = 30000L;
        long cutoff = 1649648580541L;
        if (timer < cutoff) {   //Any time that passed wont set reminder.
            Toast.makeText(AddReminder.this, "Reminder Not Set. Date Already Passed!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(AddReminder.this, "Reminder Set!", Toast.LENGTH_SHORT).show();
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            Intent intent = new Intent(AddReminder.this, receiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(AddReminder.this, (int) timer, intent, PendingIntent.FLAG_IMMUTABLE);
            //alarmManager.setExact(AlarmManager.RTC_WAKEUP, timer, pendingIntent);
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, timer, b, pendingIntent);
        }
    }

    public int getMonth(String input) {
        return Integer.parseInt(input.substring(0, 2));
    }

    public int getDay(String input) {
        return Integer.parseInt(input.substring(3, 5));
    }

    public int getYear(String input) {
        return Integer.parseInt(input.substring(6, 10));
    }

    public int getHour(String input) {
        return Integer.parseInt(input.substring(11, 13));
    }

    public int getMinute(String input) {
        return Integer.parseInt(input.substring(14, 16));
    }

    public void toHomepage() {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }
}
