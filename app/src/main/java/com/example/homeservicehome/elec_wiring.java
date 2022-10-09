package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class elec_wiring extends AppCompatActivity {
    TextView cart;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elec_wiring);

        cart = findViewById(R.id.viewcart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(elec_wiring.this,Finalcart.class);
                startActivity(intent);
            }
        });

        add = findViewById(R.id.wiring_cart);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(elec_wiring.this,Finalcart.class);
                startActivity(intent);
            }
        });
    }
}