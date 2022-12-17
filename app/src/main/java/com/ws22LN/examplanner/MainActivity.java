package com.ws22LN.examplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements View.OnClickListener {
    Button button_addExam;
    ImageButton button_deleteExam;
    RecyclerView mRecyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_addExam=(Button) findViewById(R.id.button_addExam);
        button_addExam.setOnClickListener(this);

        button_deleteExam=(ImageButton) findViewById(R.id.button_DeleteExam);
        button_deleteExam.setOnClickListener(this);

        mRecyclerview=findViewById(R.id.recyclerExams);
        ExamAdapter adapter=new ExamAdapter(this.getLayoutInflater());
        mRecyclerview.setAdapter(adapter);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

    }

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
        }
    }
}