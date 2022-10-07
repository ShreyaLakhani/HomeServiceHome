package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class plum_waterpipe extends AppCompatActivity {
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plum_waterpipe);

        add = findViewById(R.id.pipe_cart);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plum_waterpipe.this,Finalcart.class);
                startActivity(intent);
            }
        });


    }
}