package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cleaning_dashboard extends AppCompatActivity {
    Button bathroom, balcony, room, kitchen,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning_dashboard);


        bathroom = findViewById(R.id.Bathroom_btn);
        bathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cleaning_dashboard.this, clean_bathroom.class);
                startActivity(intent);
            }
        });

        balcony = findViewById(R.id.Balcony_btn);
        balcony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cleaning_dashboard.this, clean_balcony.class);
                startActivity(intent);
            }
        });
        room = findViewById(R.id.Room_btn);
        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cleaning_dashboard.this, clean_room.class);
                startActivity(intent);
            }
        });

        kitchen = findViewById(R.id.Kitchen_btn);
        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cleaning_dashboard.this, clean_kitchen.class);
                startActivity(intent);
            }
        });


    }
}