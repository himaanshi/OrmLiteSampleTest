package com.example.loginormlitesample;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by root on 18/10/16.
 */
@DatabaseTable(tableName = "info")
public class Details {

    @DatabaseField(columnName = "username" ,canBeNull = false)
    public String username;
    @DatabaseField(columnName = "city")
    public String city;
    @DatabaseField(columnName ="age")
    public  String age;
    @DatabaseField(columnName = "password")
    public  String password;
    @DatabaseField(columnName = "confirmpassword")
    public String confirmpassword;


}
