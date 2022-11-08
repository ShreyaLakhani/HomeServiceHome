package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class clean_room extends AppCompatActivity {
    Button r_add;
    TextView cart, tvLabel;
    String fetchedEmail;
    int clientId, serviceId, subServiceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean_room);

        tvLabel = findViewById(R.id.roomcleaningheading);

        getClientId();
        getServiceId();
        getSubServiceId();
        //getOrders();

        r_add = findViewById(R.id.room_cart);
        r_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper helper = new DBHelper(clean_room.this, DBHelper.DBNAME, null, 1);
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put("client_id", clientId);
                values.put("service_id", serviceId);
                values.put("sub_id", subServiceId);
                values.put("status", 0);

                long status = db.insert("orders","[order_id, order_date, order_time]", values);
                if (status >= 0) {
                    Toast.makeText(clean_room.this, "Added To Cart", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(clean_room.this,Cleaning_dashboard.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(clean_room.this, "Error", Toast.LENGTH_LONG).show();
            }
        });

        cart = findViewById(R.id.viewcart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(clean_room.this,Finalcart.class);
                startActivity(intent);
            }
        });
    }

    public void getClientId()
    {
        SharedPreferences sp = getSharedPreferences("clientCredential", MODE_PRIVATE);
        fetchedEmail = sp.getString("Email", null);

        DBHelper helper = new DBHelper(clean_room.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor records = db.rawQuery("select client_id from client where client_email='"+fetchedEmail+"'", null);
        while (records.moveToNext())
        {
            clientId = records.getInt(0);
        }
    }

    public void getServiceId()
    {
        Intent intent = getIntent();
        String str = intent.getStringExtra("Label");

        DBHelper helper = new DBHelper(clean_room.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor records = db.rawQuery("select service_id from service where service_name='"+str+"'", null);
        while (records.moveToNext())
        {
            //Log.d("Service_name", str);
            serviceId = records.getInt(0);
        }
    }

    public void getSubServiceId()
    {
        String str1 = tvLabel.getText().toString();

        DBHelper helper = new DBHelper(clean_room.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor records = db.rawQuery("select sub_id from subservice where sub_name='"+str1+"'", null);
        while (records.moveToNext())
        {
            //Log.d("Sub_Service_name", records.getString(0));
            subServiceId = records.getInt(0);
        }
    }

    public void getOrders()
    {
        DBHelper helper = new DBHelper(clean_room.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor records = db.rawQuery("select * from orders", null);
        while (records.moveToNext())
        {
            Log.d("order_id", records.getString(0));
            Log.d("client_id", records.getString(1));
            Log.d("service_id", records.getString(2));
            Log.d("subservice_id", records.getString(3));
            //subServiceId = records.getInt(0);
        }
    }
}