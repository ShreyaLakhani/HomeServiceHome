package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowRequests extends AppCompatActivity implements View.OnClickListener {
    TextView txtRequests;
    Button btnConfirm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showrequests);

        txtRequests = findViewById(R.id.txtRequests);
        txtRequests.setText("");
        btnConfirm = findViewById(R.id.btnconfirm);
        btnConfirm.setOnClickListener(ShowRequests.this);

        DBHelper helper = new DBHelper(ShowRequests.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor records = db.rawQuery("select distinct client_contact, client_address, order_date, order_time from client inner join orders where client.client_id = orders.client_id", null);
        while(records.moveToNext())
        {
            txtRequests.append("Contact : " + records.getString(0) + "\n");
            txtRequests.append("Address : " + records.getString(1) + "\n");
            txtRequests.append("Date : " + records.getString(2) + "\n");
            txtRequests.append("Time : " + records.getString(3) + "\n");
        }

        Cursor records1 = db.rawQuery("select sub_name from subservice inner join orders where subservice.sub_id = orders.sub_id", null);
        txtRequests.append("Selected services : \n\n");
        while (records1.moveToNext())
        {
            txtRequests.append("     " + records1.getString(0) + "\n");
        }
    }

    @Override
    public void onClick(View view) {
        DBHelper helper = new DBHelper(ShowRequests.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("status", 1);

        long status = db.update("orders", values, "status=0", null);
        if (status >= 0) {
            Toast.makeText(ShowRequests.this, "Service Confirmed", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ShowRequests.this, Org_dashboard.class);
            startActivity(intent);
            finish();
        }
        else
            Toast.makeText(ShowRequests.this, "Error", Toast.LENGTH_LONG).show();
    }
}