package com.example.homeservicehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Org_signup extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button signup;
    Spinner spinnerservice;
    EditText orgname, orgmail, orgphone, orgpassword, confirmorgpassword;
    String item = "";
    int service_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_signup);

        orgname = findViewById(R.id.orgname);
        orgmail = findViewById(R.id.orgmail);
        orgphone = findViewById(R.id.orgphone);
        orgpassword = findViewById(R.id.orgpassword);
        confirmorgpassword = findViewById(R.id.confirmorgpassword);

        spinnerservice = findViewById(R.id.spinnerservices);
        spinnerservice.setOnItemSelectedListener(Org_signup.this);

        signup = findViewById(R.id.signupbtn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (orgname.getText().toString().equals("") || orgmail.getText().toString().equals("") ||
                        orgphone.getText().toString().equals("") || orgpassword.getText().toString().equals("") ||
                        confirmorgpassword.getText().toString().equals(""))
                {
                    Toast.makeText(Org_signup.this, "Please Fill All Details", Toast.LENGTH_LONG).show();
                }
                else {
                    if (orgpassword.getText().toString().equals(confirmorgpassword.getText().toString())) {
                        getServiceId();
                        signUpOrg();
                    }
                    else
                        Toast.makeText(Org_signup.this, "Password do not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void getServiceId()
    {
        DBHelper helper = new DBHelper(Org_signup.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor records = db.rawQuery("select service_id from service where service_name='"+item+"'", null);

        if (records.getCount() == 1) {
            records.moveToFirst();
            service_id = records.getInt(0);
            //Toast.makeText(Org_signup.this, String.valueOf(service_id), Toast.LENGTH_SHORT).show();
        }
    }

    private void signUpOrg() {
        DBHelper helper = new DBHelper(Org_signup.this, DBHelper.DBNAME, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("org_name", orgname.getText().toString());
        values.put("org_email", orgmail.getText().toString());
        values.put("org_contact", orgphone.getText().toString());
        values.put("org_password", orgpassword.getText().toString());
        values.put("service_id", service_id);

        long status = db.insert("organization", null, values);
        if (status >= 0) {
            Toast.makeText(Org_signup.this, "Sign-Up Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Org_signup.this,Org_signin.class);
            startActivity(intent);
            finish();
        }
        else
            Toast.makeText(Org_signup.this, "Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
        item = parent.getItemAtPosition(pos).toString();
        //Toast.makeText(Org_signup.this, item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}