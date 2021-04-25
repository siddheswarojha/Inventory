package com.siddheswar.inventory.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.siddheswar.inventory.R;

import java.util.zip.Inflater;

public class MyAdapter extends CursorAdapter {
    public MyAdapter(Context context, Cursor c) {
        super(context, c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.sample_list_iem,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView quantity,name,price;
        quantity = view.findViewById(R.id.QUANTITY);
        name = view.findViewById(R.id.NAME);
        price = view.findViewById(R.id.PRICE);

        String Name = cursor.getString(cursor.getColumnIndexOrThrow("ItemName"));
        int Quantity = cursor.getInt(cursor.getColumnIndexOrThrow("Quantity"));
        Double Price = cursor.getDouble(cursor.getColumnIndexOrThrow("Price"));


        name.setText(Name);
        quantity.setText(String.valueOf(Quantity));
        price.setText(Price.toString());





    }
}
