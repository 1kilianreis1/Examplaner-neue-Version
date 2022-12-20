package com.ws22LN.examplanner;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddExamScreen extends Activity implements View.OnClickListener {
    ImageButton button_backToMain;
    Button button_SaveExam;
    EditText date;
    EditText time;
    EditText subject;
    EditText room;
    EditText comment;
    Exam theExam;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam_screen);

        date= (EditText) findViewById(R.id.editTextDate);
        time=(EditText) findViewById(R.id.editTextTime);
        subject=(EditText) findViewById(R.id.editTextSubject);
        room=(EditText) findViewById(R.id.editTextRoom);
        comment=(EditText) findViewById(R.id.editTextComment);

        button_backToMain= (ImageButton) findViewById(R.id.button_backToMain);
        button_backToMain.setOnClickListener(this);

        button_SaveExam=(Button) findViewById(R.id.button_SaveExam);
        button_SaveExam.setOnClickListener(this);
    }

//On Click commands for AddExamScreen
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button_backToMain:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
            break;

            case R.id.button_SaveExam:
                Exam e = new Exam();
                e.setDate(date.getText().toString());
                e.setTime(time.getText().toString());
                e.setSubject(subject.getText().toString());
                e.setRoom(room.getText().toString());
                e.setComment(comment.getText().toString());
                theExam=e;
                ExamCollection.allExams.add(e);
                Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();
            break;
        }
    }
}