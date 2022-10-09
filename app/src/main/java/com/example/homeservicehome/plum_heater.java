package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class plum_heater extends AppCompatActivity {
    Button addh;
    TextView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plum_heater);

        addh = findViewById(R.id.heater_cart);
        addh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plum_heater.this,Finalcart.class);
                startActivity(intent);
            }
        });

        cart = findViewById(R.id.viewcart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plum_heater.this,Finalcart.class);
                startActivity(intent);
            }
        });
    }
}