package com.siddheswar.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.siddheswar.inventory.Helper.MyHelper;

import java.util.function.DoubleUnaryOperator;

public class Form extends AppCompatActivity {

    EditText name,quantity,price;
    Button btnSave,btnList;

    String ItemName;
    int Quantity;
    Double Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        MyHelper myHelper = new MyHelper(this);
        SQLiteDatabase db = myHelper.getWritableDatabase();


        name = findViewById(R.id.etItemName);
        quantity = findViewById(R.id.etQuantity);
        price= findViewById(R.id.etPrice);
        btnSave = findViewById(R.id.btnSave);
        btnList = findViewById(R.id.btnList);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemName = name.getText().toString();
                Quantity = Integer.parseInt(quantity.getText().toString());
                Price = Double.parseDouble(price.getText().toString());
                Toast.makeText(Form.this, "Saving", Toast.LENGTH_SHORT).show();

                myHelper.addItem(db, ItemName,Quantity,Price);

                Log.d("mymessage",ItemName+Quantity+Price);





            }
        });
btnList.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i = new Intent(Form.this,MainActivity.class);
                startActivity(i);

    }
});










    }
}