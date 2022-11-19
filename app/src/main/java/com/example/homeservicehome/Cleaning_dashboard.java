package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cleaning_dashboard extends AppCompatActivity {
    Button bathroom, balcony, room, kitchen,add;
    TextView cart, tvLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning_dashboard);

        tvLabel = findViewById(R.id.cleaningtxt);

        bathroom = findViewById(R.id.Bathroom_btn);
        bathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cleaning_dashboard.this, clean_bathroom.class);
                intent.putExtra("Label", tvLabel.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        cart = findViewById(R.id.viewcart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cleaning_dashboard.this,Finalcart.class);
                startActivity(intent);
            }
        });

        balcony = findViewById(R.id.Balcony_btn);
        balcony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cleaning_dashboard.this, clean_balcony.class);
                intent.putExtra("Label", tvLabel.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        room = findViewById(R.id.Room_btn);
        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cleaning_dashboard.this, clean_room.class);
                intent.putExtra("Label", tvLabel.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        kitchen = findViewById(R.id.Kitchen_btn);
        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cleaning_dashboard.this, clean_kitchen.class);
                intent.putExtra("Label", tvLabel.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}