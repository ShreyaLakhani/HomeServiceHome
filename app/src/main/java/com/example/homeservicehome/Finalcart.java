package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

public class Finalcart extends AppCompatActivity {
    ListView servicesList;
    TimePicker tp;
    String fetchedEmail;
    int clientId;
    Orders[] order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalcart);

        getClientId();

        servicesList = findViewById(R.id.serviceslist);
        tp = findViewById(R.id.datePicker);
        tp.setIs24HourView(true);

        DBHelper helper = new DBHelper(Finalcart.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor records = db.rawQuery("select sub_id from orders where client_id='"+clientId+"' and status=0", null);
        while (records.moveToNext()) {
            int serviceId = records.getInt(0);

            Cursor record1 = db.rawQuery("select sub_name, sub_rate from subservice where sub_id='"+serviceId+"'", null);

            order = new Orders[record1.getCount()];
            int i = 0;
            while (record1.moveToNext())
            {
                //Log.d("sub_name", record1.getString(0));
                //Log.d("sub_rate", String.valueOf(record1.getFloat(1)));
                
                order[i] = new Orders();
                order[i].setSub_name(record1.getString(0));
                order[i].setSub_rate(record1.getFloat(1));
                i++;

                BaseAdapter adapter = new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return order.length;
                    }

                    @Override
                    public Object getItem(int i) {
                        return order[i];
                    }

                    @Override
                    public long getItemId(int i) {
                        return 0;
                    }

                    @Override
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        LinearLayout ll = (LinearLayout) getLayoutInflater().inflate(R.layout.layout_list, null);

                        TextView tvSubName = ll.findViewById(R.id.tvSubServiceName);
                        TextView tvSubRate = ll.findViewById(R.id.tvAmount);

                        tvSubName.setText(order[i].getSub_name());
                        tvSubRate.setText(String.valueOf(order[i].getSub_rate()));

                        return ll;
                    }
                };
                servicesList.setAdapter(adapter);
            }
        }
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
}