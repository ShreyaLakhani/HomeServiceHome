package com.example.homeservicehome;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "DbHomeService";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBNAME, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*String query = "create table service\n" +
                "(\n" +
                "\tservice_id int PRIMARY KEY,\n" +
                "\tservice_name text\n" +
                ");";*/

        String query = "create table subservice\n" +
                "(\n" +
                "\tsub_id int PRIMARY KEY,\n" +
                "\tsub_name text,\n" +
                "\tsub_rate float,\n" +
                "\tservice_id int,\n" +
                "\tCONSTRAINT fk_serviceid FOREIGN KEY(service_id) REFERENCES service(service_id)\n" +
                ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
