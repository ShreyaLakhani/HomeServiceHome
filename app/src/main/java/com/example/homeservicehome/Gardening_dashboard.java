package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Gardening_dashboard extends AppCompatActivity {
    Button Pond, landscape, trim, lawn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardening_dashboard);

        Pond = findViewById(R.id.Pond_btn);
        landscape = findViewById(R.id.Landscape_btn);
        trim = findViewById(R.id.Pruning_btn);
        lawn = findViewById(R.id.Lawn_btn);
    }
}