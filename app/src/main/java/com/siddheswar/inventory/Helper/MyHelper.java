package com.siddheswar.inventory.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {


    public static final String DBNAME = "Inventory";
    public static final int DBversion = 1;
    public MyHelper( Context context) {
        super(context, DBNAME, null, DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String querry = "CREATE TABLE Inventory (_id INTEGER PRIMARY KEY AUTOINCREMENT, ItemName TEXT, Quantity INTEGER, Price Double)";
        db.execSQL(querry);


    }


    public void addItem(SQLiteDatabase db,String ItemName,int Quantity, Double Price)
    {
        ContentValues cv = new ContentValues();
        cv.put("ItemName",ItemName);
        cv.put("Quantity",Quantity);
        cv.put("Price",Price);
        db.insert("Inventory",null,cv);
        Log.d("datumama",ItemName+Quantity+Price);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
