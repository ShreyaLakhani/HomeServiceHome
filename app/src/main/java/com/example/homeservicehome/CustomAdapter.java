package com.example.homeservicehome;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    Orders[] orderData;
    LayoutInflater inflater;

    public CustomAdapter(Context context, Orders[] orders) {
        this.context = context;
        this.orderData = orders;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
//        Log.i("vishal","Size in adp: " + orderData.length);
        return orderData.length;
    }

    @Override
    public Object getItem(int i) {
        return orderData[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView==null)
        {
            rowView = inflater.inflate(R.layout.layout_list, null, true);
        }

            TextView tvSubName = rowView.findViewById(R.id.tvSubServiceName);
            TextView tvSubRate = rowView.findViewById(R.id.tvAmount);
//            Log.i("vishal","Data adp: " + orderData[i].getSub_name());
            tvSubName.setText(orderData[i].getSub_name());
            tvSubRate.setText(String.valueOf(orderData[i].getSub_rate()));

        return rowView;
    }
}
