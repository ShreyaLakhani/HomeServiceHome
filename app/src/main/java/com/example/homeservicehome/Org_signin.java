package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Org_signin extends AppCompatActivity {
    Button signin,forgot;
    TextView createacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_signin);

        signin = findViewById(R.id.nextbtn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Org_signin.this,Org_dashboard.class);
                startActivity(intent);
            }
        });

        createacc = findViewById(R.id.createaccount);
        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Org_signin.this,Org_signup.class);
                startActivity(intent);
            }
        });

    }
}