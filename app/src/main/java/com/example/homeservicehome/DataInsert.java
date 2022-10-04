package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
                insertData();
            }
        });
    }

    private void insertData() {
        DBHelper helper = new DBHelper(DataInsert.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("service_name", "Cleaning");
        /*values.put("service_name", "Gardening");
        values.put("service_name", "Plumbing");
        values.put("service_name", "Electricity");*/

        long status = db.insert("service", null, values);
        if (status >= 0)
            Toast.makeText(DataInsert.this, "Record Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(DataInsert.this, "Error", Toast.LENGTH_LONG).show();
    }
}