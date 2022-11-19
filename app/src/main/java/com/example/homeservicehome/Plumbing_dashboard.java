package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Plumbing_dashboard extends AppCompatActivity {
    TextView cart;
    Button water, heater, toilet, motor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumbing_dashboard);

        cart = findViewById(R.id.viewcart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Plumbing_dashboard.this,Finalcart.class);
                startActivity(intent);
            }
        });

        water = findViewById(R.id.Waterpipe_btn);
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Plumbing_dashboard.this,plum_waterpipe.class);
                startActivity(intent);
            }
        });
        heater = findViewById(R.id.Waterheater_btn);
        heater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Plumbing_dashboard.this,plum_heater.class);
                startActivity(intent);
            }
        });
        toilet = findViewById(R.id.Toiletsink_btn);
        toilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Plumbing_dashboard.this,plum_sink.class);
                startActivity(intent);
            }
        });
        motor = findViewById(R.id.Motor_btn);
        motor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Plumbing_dashboard.this,plum_motor.class);
                startActivity(intent);
            }
        });
    }
}