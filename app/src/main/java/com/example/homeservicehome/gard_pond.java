package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gard_pond extends AppCompatActivity {
    Button addpond;
    TextView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gard_pond);

        addpond = findViewById(R.id.pond_cart);
        addpond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(gard_pond.this,Finalcart.class);
                startActivity(intent);
            }
        });

        cart = findViewById(R.id.viewcart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(gard_pond.this,Finalcart.class);
                startActivity(intent);
            }
        });
    }
}