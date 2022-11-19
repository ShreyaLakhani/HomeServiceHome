package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Org_dashboard extends AppCompatActivity implements AdapterView.OnItemClickListener {
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
        reqlist.setOnItemClickListener(Org_dashboard.this);

        helper = new DBHelper(Org_dashboard.this, DBHelper.DBNAME, null, 1);
        db = helper.getReadableDatabase();

        Cursor records = db.rawQuery("select distinct client_uname, client_contact from client inner join orders where client.client_id = orders.client_id and orders.status=0", null);
        int i = 0;
        org = new Orders_org[records.getCount()];

        while (records.moveToNext())
        {
            org[i] = new Orders_org();
            org[i].setClient_name(records.getString(0));
            org[i].setClient_contact(records.getString(1));

            i++;
        }

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

                tvName.setText(org[i].getClient_name());
                tvContact.setText(org[i].getClient_contact());

                return ll;
            }
        };

        reqlist.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(Org_dashboard.this, ShowRequests.class);
        startActivity(intent);
    }
}