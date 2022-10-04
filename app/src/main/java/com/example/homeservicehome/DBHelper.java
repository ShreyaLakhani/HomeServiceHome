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
        String query = "create table services\n" +
                "(\n" +
                "\tservice_id int PRIMARY KEY AUTOINCREMENT,\n" +
                "\tservice_name text\n" +
                ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
