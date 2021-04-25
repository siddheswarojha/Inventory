package com.siddheswar.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.siddheswar.inventory.Adapter.MyAdapter;
import com.siddheswar.inventory.Helper.MyHelper;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    ListView LS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);
        LS = findViewById(R.id.LS);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Form.class);
                startActivity(i);
            }
        });

        MyHelper myHelper = new MyHelper(this);
        SQLiteDatabase db= myHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Inventory",null);

        MyAdapter myAdapter = new MyAdapter(this,cursor);
        LS.setAdapter(myAdapter);
        myAdapter.changeCursor(cursor);








    }
}