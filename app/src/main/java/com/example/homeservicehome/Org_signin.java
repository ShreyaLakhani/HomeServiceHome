package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Org_signin extends AppCompatActivity {
    Button signin;
    TextView createacc, forgot;
    EditText orgmail, orgpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_signin);

        orgmail = findViewById(R.id.orgmail);
        orgpassword = findViewById(R.id.orgpassword);

        signin = findViewById(R.id.signinbtn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (orgmail.getText().toString().equals("") || orgpassword.getText().toString().equals(""))
                    Toast.makeText(Org_signin.this, "Please Fill All Details", Toast.LENGTH_LONG).show();
                else
                    signInOrg();
            }
        });

        forgot = findViewById(R.id.orgfp);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Org_signin.this,Org_forgot_password.class);
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

    private void signInOrg() {
        DBHelper helper = new DBHelper(Org_signin.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor records = db.rawQuery("select org_email, org_password from organization where org_email='"+orgmail.getText().toString()+"' and org_password='"+orgpassword.getText().toString()+"'", null);

        if (records.getCount() >= 1) {
            Toast.makeText(Org_signin.this, "Sign-In Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Org_signin.this,Org_dashboard.class);
            startActivity(intent);
            finish();
        }
        else
            Toast.makeText(Org_signin.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
    }
}