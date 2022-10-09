package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class plum_sink extends AppCompatActivity {
    Button add;
    TextView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plum_sink);

        add = findViewById(R.id.sink_cart);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plum_sink.this,Finalcart.class);
                startActivity(intent);
            }
        });

        cart = findViewById(R.id.viewcart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plum_sink.this,Finalcart.class);
                startActivity(intent);
            }
        });
    }
}