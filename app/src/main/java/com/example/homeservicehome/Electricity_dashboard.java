package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Electricity_dashboard extends AppCompatActivity {
    TextView cart;
    Button wire, fan,light, switchsoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_dashboard);

        cart = findViewById(R.id.viewcart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Electricity_dashboard.this,Finalcart.class);
                startActivity(intent);
            }
        });
        wire = findViewById(R.id.Wiring_btn);
        wire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Electricity_dashboard.this,elec_wiring.class);
                startActivity(intent);
            }
        });
        fan = findViewById(R.id.Fan_btn);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Electricity_dashboard.this,elec_fan.class);
                startActivity(intent);
            }
        });
        light = findViewById(R.id.FestiveLight_btn);
        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Electricity_dashboard.this,elec_light.class);
                startActivity(intent);
            }
        });
        switchsoc = findViewById(R.id.Switch_btn);
        switchsoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Electricity_dashboard.this,elec_switch.class);
                startActivity(intent);
            }
        });
    }
}