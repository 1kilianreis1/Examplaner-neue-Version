package com.ws22LN.examplanner;

import static com.ws22LN.examplanner.Notifs.notifyTEST_ID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements View.OnClickListener {
    Button button_addExam;
    Button button_testNotif;
    ImageButton button_deleteExam;
    RecyclerView mRecyclerview;
    private NotificationManagerCompat notifManager;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        notifManager=NotificationManagerCompat.from(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_addExam=(Button) findViewById(R.id.button_addExam);
        button_addExam.setOnClickListener(this);

        button_deleteExam=(ImageButton) findViewById(R.id.button_DeleteExam);
        button_deleteExam.setOnClickListener(this);

        button_testNotif=(Button)findViewById(R.id.button_testNotif);

        mRecyclerview=findViewById(R.id.recyclerExams);
        ExamAdapter adapter=new ExamAdapter(this.getLayoutInflater());
        mRecyclerview.setAdapter(adapter);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

    }

    //Funktion zum Testen von Notifications
    public void sendNotifTEST(View view)
    {
        Notification notifTEST= new NotificationCompat.Builder(this, notifyTEST_ID)
                .setSmallIcon(R.drawable.ic_test)
                .setContentTitle("TEST")
                .setContentText("This is a test notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_EVENT)
                .build();
        notifManager.notify(1, notifTEST);
    }

    //onClick für Buttons in Main
    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.button_addExam:
                Intent intent = new Intent(this, AddExamScreen.class);
                startActivity(intent);
                break;

           /* case R.id.button_DeleteExam:
                Intent intent = new Intent(this, );
                startActivity(intent);
                break;
            */
            case R.id.button_testNotif:

                break;
        }
    }
}