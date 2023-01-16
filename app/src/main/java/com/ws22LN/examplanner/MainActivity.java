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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity
{
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

        //button_testNotif=(Button)findViewById(R.id.button_testNotif);

        mRecyclerview=findViewById(R.id.recyclerExams);
        ExamAdapter adapter=new ExamAdapter(this.getLayoutInflater());
        mRecyclerview.setAdapter(adapter);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        //DB Kommunikation
        try
        {
            URL url = new URL ("http://localhost:8080/examcontroller/getallexam");
            HttpURLConnection connection =(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            Map<String, String> parameters =new HashMap<>();
            parameters.put("parameter1", "value");

            DataOutputStream outputStream=new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            outputStream.flush();
            connection.setRequestProperty("Content-Type","application/json");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while((inputLine=in.readLine())!=null)
            {
                content.append(inputLine);
                System.out.println(inputLine);
            }
            in.close();

        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    //onClick für Add Exam Button
    public void switchToAddExam(View view)
    {
        Intent intent = new Intent(this, AddExamScreen.class);
        startActivity(intent);
    }

    //Funktion zum Testen von Notifications
    /*public void sendNotifTEST(View view)
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

     */
}