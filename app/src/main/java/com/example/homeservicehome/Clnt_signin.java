package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Clnt_signin extends AppCompatActivity {
    Button signin;
    TextView createacc, forgot;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clnt_signin);

        signin = findViewById(R.id.signinbtn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clnt_signin.this,Clnt_dashboard.class);
                startActivity(intent);
            }
        });

        createacc = findViewById(R.id.createaccount);
        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clnt_signin.this,Clnt_signup.class);
                startActivity(intent);
            }
        });

        forgot = findViewById(R.id.clntfp);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clnt_signin.this,Clnt_forgot_password.class);
                startActivity(intent);
            }
        });
    }
}