package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DataInsert extends AppCompatActivity {
    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_insert);

        btnInsert = findViewById(R.id.btnInsertData);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insertServices();
                //showServices();
                insertSubServices();
            }
        });
    }

    private void insertServices() {
        DBHelper helper = new DBHelper(DataInsert.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        //values.put("service_id", 1);
        //values.put("service_name", "Cleaning");
        //values.put("service_id", 2);
        //values.put("service_name", "Gardening");
        //values.put("service_id", 3);
        //values.put("service_name", "Plumbing");
        //values.put("service_id", 4);
        //values.put("service_name", "Electricity");

        long status = db.insert("service", null, values);
        if (status >= 0)
            Toast.makeText(DataInsert.this, "4 Record Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(DataInsert.this, "Error", Toast.LENGTH_LONG).show();
    }

    private void showServices() {
            DBHelper helper = new DBHelper(DataInsert.this, DBHelper.DBNAME, null, 1);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor records = db.query("service", null, null, null, null, null, null);
            while (records.moveToNext())
            {
                Log.d("service_id", records.getString(0));
                Log.d("service_name", records.getString(1));
            }
    }

    private void insertSubServices() {
        DBHelper helper = new DBHelper(DataInsert.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

//        values.put("sub_id", 5);
//        values.put("sub_name", "Pond Installation");
//        values.put("sub_rate", 599);
//        values.put("service_id", 1);

        long status = db.insert("subservice", null, values);
        if (status >= 0)
            Toast.makeText(DataInsert.this, "5 Record Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(DataInsert.this, "Error", Toast.LENGTH_LONG).show();
    }
}