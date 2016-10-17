
package com.example.root.ormlitesampletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class AddStudentActivity extends AppCompatActivity  implements View.OnClickListener{
    Button btn_reset,btn_save;
    EditText et_name,et_rollno,et_grade;

    // Reference of DatabaseHelper class to access its DAOs and other components
    private DatabaseHelper databaseHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        et_name= (EditText) findViewById(R.id.studentname);
        et_rollno= (EditText) findViewById(R.id.studentRollNo);
        et_grade= (EditText) findViewById(R.id.studentgrade);
        btn_reset= (Button) findViewById(R.id.reset);
        btn_save= (Button) findViewById(R.id.save);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reset:
                reset();
                break;
            case R.id.save:
                saveData();
                break;
        }
    }
    // Clear the entered text
    private void reset()
    {
        et_name.setText("");
        et_rollno.setText("");
        et_grade.setText("");
    }
    private void saveData(){
// Create the StudentDetails object and set the inputed data into it
        final StudentDetails stuDetails = new StudentDetails();
        stuDetails.studentName = et_name.getText().toString();
        stuDetails.rollNo = et_rollno.getText().toString();
        stuDetails.grade = et_grade.getText().toString();
        try {
            // Now, need to interact with StudentDetails table/object, so initialize DAO for that
            final Dao<StudentDetails, Integer> studentDao = getHelper().getStudentDao();

            //This is the way to insert data into a database table
            studentDao.create(stuDetails);
            reset();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // This is how, DatabaseHelper can be initialized for future use
    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this,DatabaseHelper.class);
        }
        return databaseHelper;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

		/*
		 * You'll need this in your class to release the helper when done.
		 */
        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }

}
