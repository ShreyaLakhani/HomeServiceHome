package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

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

public class Org_dashboard extends AppCompatActivity {
    ListView reqlist;
    int sub_id;
    DBHelper helper;
    SQLiteDatabase db;
    Orders_org[] org;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_dashboard);
        reqlist = findViewById(R.id.requestlist);

        helper = new DBHelper(Org_dashboard.this, DBHelper.DBNAME, null, 1);
        db = helper.getReadableDatabase();
        Cursor records = db.rawQuery("select client_uname, client_contact, client_address, sub_id, order_date, order_time from client inner join orders where client.client_id = orders.client_id", null);
        while (records.moveToNext()) {

            sub_id = records.getInt(3);

            Cursor records1 = db.rawQuery("select sub_name, sub_rate from subservice where sub_id='"+sub_id+"'", null);

            org = new Orders_org[records.getCount()];
            int i = 0;
            while(records1.moveToNext())
            {
//                Log.d("Client name", records.getString(0));
//                Log.d("Client contact", records.getString(1));
//                Log.d("Client address", records.getString(2));

//                Log.d("Sub id", records.getString(3));
//                Log.d("sub_name", records1.getString(0));
//                Log.d("sub_rate", String.valueOf(records.getFloat(1)));

                //Log.d("Order date", records.getString(4));
                //Log.d("Order time", records.getString(5));

                org[i] = new Orders_org();
                org[i].setClient_name(records.getString(0));
                org[i].setClient_contact(records.getString(1));
                org[i].setClient_address(records.getString(2));
                org[i].setSub_name(records1.getString(0));
                org[i].setSub_rate(records1.getFloat(1));
                //org[i].setDate(records.getString(4));
                //org[i].setTime(records.getString(5));

                //Log.d("Orders", org[i].toString());
                i++;

                BaseAdapter adapter = new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return org.length;
                    }

                    @Override
                    public Object getItem(int i) {
                        return org[i];
                    }

                    @Override
                    public long getItemId(int i) {
                        return 0;
                    }

                    @Override
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        LinearLayout ll = (LinearLayout) getLayoutInflater().inflate(R.layout.layout_list_org, null);

                        TextView tvName = ll.findViewById(R.id.tvClientName);
                        TextView tvContact = ll.findViewById(R.id.tvClientContact);
                        TextView tvAddress = ll.findViewById(R.id.tvClientAddress);
                        TextView tvSubName = ll.findViewById(R.id.tvSubName);
                        TextView tvSubRate = ll.findViewById(R.id.tvSubRate);
                        //TextView tvDate = ll.findViewById(R.id.tvDate);
                        //TextView tvTime = ll.findViewById(R.id.tvTime);

                        tvName.setText(org[i].getClient_name());
                        tvContact.setText(org[i].getClient_contact());
                        tvAddress.setText(org[i].getClient_address());
                        tvSubName.setText(org[i].getSub_name());
                        tvSubRate.setText(String.valueOf(org[i].getSub_rate()));
                        //tvDate.setText(org[i].getDate());
                        //tvTime.setText(org[i].getTime());

                        return ll;
                    }
                };
                reqlist.setAdapter(adapter);
            }
        }
    }
}