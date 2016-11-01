package com.example.loginormlitesample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by root on 18/10/16.
 */

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "studentdir.db";
    private static final int DATABASE_VERSION = 1;
    private Dao<Details,Integer> detailsIntegerDao;


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource,Details.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource,Details.class,true);
            onCreate(sqLiteDatabase,connectionSource);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }
    public Dao<Details, Integer> detailsIntegerDao() throws SQLException {
        if (detailsIntegerDao == null) {
            detailsIntegerDao = getDao(Details.class);
        }
        return detailsIntegerDao;
    }
}
