package com.example.reminderapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras=intent.getExtras();
        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, "Noti");
        notification.setContentTitle("Testing");
        notification.setContentText("Working???");
        notification.setSmallIcon(R.drawable.ic_notifications);
        notification.setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(1, notification.build());

    }
}
