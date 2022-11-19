package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;

public class Finalcart extends AppCompatActivity implements View.OnClickListener, TimePicker.OnTimeChangedListener, DatePicker.OnDateChangedListener {
    ListView servicesList;
    TimePicker tp;
    DatePicker dt;
    TextView totalAmount;
    Button btnConfirm;
    String fetchedEmail;
    int clientId;
    ArrayList<Orders> arrList;
    Orders[] order;
    CustomAdapter adapter;
    Context context;
    String strSubName, time, date;
    Float fltSubRate;
    float rate = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalcart);
        context = this;
        arrList = new ArrayList<Orders>();

        getClientId();

        servicesList = findViewById(R.id.serviceslist);
        tp = findViewById(R.id.tp);
        tp.setOnTimeChangedListener(Finalcart.this);
        dt = findViewById(R.id.dp);
        dt.setOnDateChangedListener(Finalcart.this);
        totalAmount = findViewById(R.id.amounttxtspace);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(Finalcart.this);
        tp.setIs24HourView(false);

        DBHelper helper = new DBHelper(Finalcart.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor records = db.rawQuery("select sub_id from orders where client_id='"+clientId+"' and status=0", null);
        int i = 0;
        order = new Orders[records.getCount()];

        while (records.moveToNext())
        {
            order[i] = new Orders();
            int serviceId = records.getInt(0);

            Cursor record1 = db.rawQuery("select sub_name, sub_rate from subservice where sub_id='"+serviceId+"'", null);
            while (record1.moveToNext())
            {
                strSubName = record1.getString(0);
                fltSubRate = record1.getFloat(1);
                rate = rate + fltSubRate;
            }
            order[i].setSub_rate(fltSubRate);
            order[i].setSub_name(strSubName);
            i++;
        }

        totalAmount.setText("Estimated amount : "+String.valueOf(rate));
        adapter = new CustomAdapter(context, order);
        servicesList.setAdapter(adapter);
    }

    public void getClientId()
    {
        SharedPreferences sp = getSharedPreferences("clientCredential", MODE_PRIVATE);
        fetchedEmail = sp.getString("Email", null);

        DBHelper helper = new DBHelper(Finalcart.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor records = db.rawQuery("select client_id from client where client_email='"+fetchedEmail+"'", null);
        while (records.moveToNext())
        {
            clientId = records.getInt(0);
        }
    }

    @Override
    public void onClick(View view) {
        DBHelper helper = new DBHelper(Finalcart.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("order_date", date);
        values.put("order_time", time);

        long status = db.update("orders", values, "client_id='"+clientId+"' and status=0", null);
        if (status >= 0) {
            Toast.makeText(Finalcart.this, "Service confirmed", Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(Finalcart.this,Showconfirmation.class);
            //startActivity(intent);
            //finish();
        }
        else
            Toast.makeText(Finalcart.this, "Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int i, int i1) {
        time = i + " : " + i1;
        //Log.d("Time", time);
    }

    @Override
    public void onDateChanged(DatePicker datePicker, int year, int m, int day) {
        int month = m + 1;
        date = day + "/" + month + "/" + year;
        //Log.d("date", date);
    }
}