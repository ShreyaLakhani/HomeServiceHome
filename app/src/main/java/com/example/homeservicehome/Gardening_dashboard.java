package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Gardening_dashboard extends AppCompatActivity {
    Button Pond, landscape, trim, lawn;
    TextView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardening_dashboard);

        cart = findViewById(R.id.viewcart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gardening_dashboard.this,Finalcart.class);
                startActivity(intent);
            }
        });

        Pond = findViewById(R.id.Pond_btn);
        Pond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gardening_dashboard.this, gard_pond.class);
                startActivity(intent);
            }
        });

        landscape = findViewById(R.id.Landscape_btn);
        landscape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gardening_dashboard.this, gard_land.class);
                startActivity(intent);
            }
        });
        trim = findViewById(R.id.Pruning_btn);
        trim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gardening_dashboard.this, gard_trim.class);
                startActivity(intent);
            }
        });
        lawn = findViewById(R.id.Lawn_btn);
        lawn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gardening_dashboard.this, gard_lawn.class);
                startActivity(intent);
            }
        });
    }
}