package com.example.homeservicehome;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "DbHomeService";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBNAME, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table service\n" +
                "(\n" +
                "\tservice_id int PRIMARY KEY,\n" +
                "\tservice_name text\n" +
                ");";

        db.execSQL(query);

        String query1 = "create table subservice\n" +
                "(\n" +
                "\tsub_id int PRIMARY KEY,\n" +
                "\tsub_name text,\n" +
                "\tsub_rate float,\n" +
                "\tservice_id int,\n" +
                "\tCONSTRAINT fk_serviceid FOREIGN KEY(service_id) REFERENCES service(service_id)\n" +
                ");";

        db.execSQL(query1);

        String query2 = "create table client\n" +
                "(\n" +
                "\tclient_id integer PRIMARY KEY autoincrement,\n" +
                "\tclient_uname text,\n" +
                "\tclient_email text,\n" +
                "\tclient_address text,\n" +
                "\tclient_citystate text,\n" +
                "\tclient_contact text,\n" +
                "\tclient_password text\n" +
                ");";

        db.execSQL(query2);

        String query3 = "create table organization\n" +
                "(\n" +
                "\torg_id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "\torg_name text,\n" +
                "\torg_email text,\n" +
                "\torg_contact text,\n" +
                "\torg_password text,\n" +
                "\tservice_id int,\n" +
                "\tCONSTRAINT fk_serviceid FOREIGN KEY(service_id) REFERENCES service(service_id)\n" +
                ");";

        db.execSQL(query3);

        String query4 = "create table orders\n" +
                "(\n" +
                "\torder_id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "\tclient_id int,\n" +
                "\tservice_id int,\n" +
                "\tsub_id int,\n" +
                "\torder_date text,\n" +
                "\torder_time text,\n" +
                "\tstatus int,\n" +
                "\tCONSTRAINT fk_clientid FOREIGN KEY(client_id) REFERENCES client(client_id),\n" +
                "\tCONSTRAINT fk_serviceid FOREIGN KEY(service_id) REFERENCES service(service_id),\n" +
                "\tCONSTRAINT fk_subid FOREIGN KEY(sub_id) REFERENCES subservice(sub_id)\n" +
                ");";

        db.execSQL(query4);

        String query5 = "create table status\n" +
                "(\n" +
                "\tstatus_id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "\tstatus_name text,\n" +
                "\torder_id int,\n" +
                "\tCONSTRAINT fk_orderid FOREIGN KEY(order_id) REFERENCES orders(order_id)\n" +
                ");";

        db.execSQL(query5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String str1 = "drop table if exists orders";
        db.execSQL(str1);
    }
}
