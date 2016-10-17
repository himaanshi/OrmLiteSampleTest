package com.example.root.ormlitesampletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button add_student_btn, view_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialization of all four buttons of the Main screen
        add_student_btn = (Button) findViewById(R.id.addStudent);
        view_btn = (Button) findViewById(R.id.viewStudent);

        // Attachment of onClickListner for them
        add_student_btn.setOnClickListener(this);
        view_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // Render StudentAddActivity screen once click on "Add Student" Button
        Log.v("abc", "" + v);
        if (v == add_student_btn) {
            startActivity(new Intent(this, AddStudentActivity.class));
        }

        // Render ViewStudentRecordActivity screen once click on "View Student Records" Button
        else  {
            startActivity(new Intent(this, ViewStudentRecordActivity.class));
        }

        }
    }

