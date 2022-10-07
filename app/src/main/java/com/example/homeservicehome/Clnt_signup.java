package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Clnt_signup extends AppCompatActivity {
    Button signupbtn;
    EditText clntname, clntmail, clntadd, clntstate, clntphone, clntpassword, clntconfirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clnt_signup);

        clntname = findViewById(R.id.clntname);
        clntmail = findViewById(R.id.clntmail);
        clntadd = findViewById(R.id.clntadd);
        clntstate = findViewById(R.id.clntstate);
        clntphone = findViewById(R.id.clntphone);
        clntpassword = findViewById(R.id.clntpassword);
        clntconfirmpassword = findViewById(R.id.confirmclntpassword);
        signupbtn = findViewById(R.id.signupbtn);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clntname.getText().toString().equals("") || clntmail.getText().toString().equals("") ||
                        clntadd.getText().toString().equals("") || clntstate.getText().toString().equals("") ||
                        clntphone.getText().toString().equals("") || clntpassword.getText().toString().equals("") ||
                        clntconfirmpassword.getText().toString().equals("")) {
                    Toast.makeText(Clnt_signup.this, "Please Fill All Details", Toast.LENGTH_LONG).show();
                }
                else {
                    if (clntpassword.getText().toString().equals(clntconfirmpassword.getText().toString()))
                        signUpClient();
                    else
                        Toast.makeText(Clnt_signup.this, "Password do not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void signUpClient() {
        DBHelper helper = new DBHelper(Clnt_signup.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("client_uname", clntname.getText().toString());
        values.put("client_email", clntmail.getText().toString());
        values.put("client_address", clntadd.getText().toString());
        values.put("client_citystate", clntstate.getText().toString());
        values.put("client_contact", clntphone.getText().toString());
        values.put("client_password", clntpassword.getText().toString());

        long status = db.insert("client", null, values);
        if (status >= 0) {
            Toast.makeText(Clnt_signup.this, "Sign-Up Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Clnt_signup.this,Clnt_signin.class);
            startActivity(intent);
        }
        else
            Toast.makeText(Clnt_signup.this, "Error", Toast.LENGTH_LONG).show();
    }
}