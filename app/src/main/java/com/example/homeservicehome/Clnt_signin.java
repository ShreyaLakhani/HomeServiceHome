package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Clnt_signin extends AppCompatActivity {
    Button signin;
    TextView createacc, forgot;
    EditText clntmail, clntpassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clnt_signin);

        clntmail = findViewById(R.id.clntmail);
        clntpassword = findViewById(R.id.clntpassword);
        forgot = findViewById(R.id.clntfp);
        createacc = findViewById(R.id.createaccount);
        signin = findViewById(R.id.signinbtn);

        SharedPreferences sp = getSharedPreferences("clientCredential", MODE_PRIVATE);
        String fetchedEmail = sp.getString("Email", null);
        String fetchedPassword = sp.getString("Password", null);

        if (fetchedEmail != "" && fetchedPassword != "") {
            Intent intent = new Intent(Clnt_signin.this, Clnt_dashboard.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Intent intent = new Intent(Clnt_signin.this, Clnt_signin.class);
            startActivity(intent);
            finish();
        }

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clntmail.getText().toString().equals("") || clntpassword.getText().toString().equals("")) {
                    Toast.makeText(Clnt_signin.this, "Please Fill All Details", Toast.LENGTH_LONG).show();
                }
                else
                    signInClient();
            }
        });

        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clnt_signin.this,Clnt_signup.class);
                startActivity(intent);
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clnt_signin.this,Clnt_forgot_password.class);
                startActivity(intent);
            }
        });
    }

    private void signInClient() {
        DBHelper helper = new DBHelper(Clnt_signin.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor records = db.rawQuery("select client_email, client_password from client where client_email='"+clntmail.getText().toString()+"' and client_password='"+clntpassword.getText().toString()+"'", null);

        if (records.getCount() >= 1) {
            Toast.makeText(Clnt_signin.this, "Sign-In Successful", Toast.LENGTH_LONG).show();

            SharedPreferences sp = getSharedPreferences("clientCredential", MODE_PRIVATE);
            SharedPreferences.Editor spEditor = sp.edit();
            spEditor.putString("Email", clntmail.getText().toString());
            spEditor.putString("Password", clntpassword.getText().toString());
            spEditor.apply();

            Intent intent = new Intent(Clnt_signin.this,Clnt_dashboard.class);
            startActivity(intent);
            finish();
        }
        else
            Toast.makeText(Clnt_signin.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
    }
}