package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Org_dashboard extends AppCompatActivity {
    ListView reqlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_dashboard);
        reqlist = findViewById(R.id.requestlist);
    }
}