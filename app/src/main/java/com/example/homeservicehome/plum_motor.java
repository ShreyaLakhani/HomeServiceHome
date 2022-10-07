package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class plum_motor extends AppCompatActivity {
    Button addm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plum_motor);

        addm = findViewById(R.id.motor_cart);
        addm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plum_motor.this,Finalcart.class);
                startActivity(intent);
            }
        });
    }
}