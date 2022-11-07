package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Clnt_dashboard extends AppCompatActivity {
    Button clean, plum, elec, garden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clnt_dashboard);

        clean = findViewById(R.id.Cleaning_btn);
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clnt_dashboard.this,Cleaning_dashboard.class);
                startActivity(intent);
            }
        });

        plum = findViewById(R.id.Plumbing_btn);
        plum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clnt_dashboard.this,Plumbing_dashboard.class);
                startActivity(intent);
            }
        });

        elec = findViewById(R.id.Electricity_btn);
        elec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clnt_dashboard.this,Electricity_dashboard.class);
                startActivity(intent);
            }
        });
        garden = findViewById(R.id.Gardening_btn);
        garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clnt_dashboard.this, Gardening_dashboard.class);
                startActivity(intent);
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action, menu);
        return super.onCreateOptionsMenu(menu);
    }*/
}