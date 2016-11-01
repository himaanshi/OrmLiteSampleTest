package com.example.loginormlitesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class SignUpActivity extends AppCompatActivity {
    EditText et_username,et_city,et_age,et_password,et_confirmpassword;
    Button btn_save;
    // Reference of DatabaseHelper class to access its DAOs and other components
    private DataBaseHelper databaseHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        et_username= (EditText) findViewById(R.id.username_et);
        et_city= (EditText) findViewById(R.id.city_et);
        et_age= (EditText) findViewById(R.id.age_et);
        et_password= (EditText) findViewById(R.id.password_et);
        et_confirmpassword= (EditText) findViewById(R.id.confirmpassword_et);
        btn_save= (Button) findViewById(R.id.save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData();

            }
        });

    }
    public  void  fetchData(){
        Details details=new Details();
        details.username =et_username.getText().toString();
        details.password=et_password.getText().toString();
        details.age=et_age.getText().toString();
        details.password=et_password.getText().toString();
        details.confirmpassword=et_confirmpassword.getText().toString();
        details.city=et_city.getText().toString();
        try {
            // Now, need to interact with StudentDetails table/object, so initialize DAO for that
            final Dao<Details, Integer> dao = getHelper().detailsIntegerDao();
            //This is the way to insert data into a database table
            dao.create(details);
            Toast.makeText(this, "Sign up Successfully", Toast.LENGTH_SHORT).show();
            finish();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // This is how, DatabaseHelper can be initialized for future use
    private DataBaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this,DataBaseHelper.class);
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
