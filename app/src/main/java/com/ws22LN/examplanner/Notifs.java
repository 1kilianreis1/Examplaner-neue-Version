package com.ws22LN.examplanner;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Notifs extends Application
{
    public static final String notifyTEST_ID="channel1";

    @Override
    public void onCreate()
    {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
        {
            NotificationChannel channel1= new NotificationChannel(notifyTEST_ID, "Test Channel", NotificationManager.IMPORTANCE_DEFAULT);
            channel1.setDescription("NotificationTEST");

            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }
}
