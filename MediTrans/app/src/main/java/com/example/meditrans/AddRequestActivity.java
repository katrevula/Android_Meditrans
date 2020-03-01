package com.example.meditrans;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddRequestActivity extends AppCompatActivity {
    EditText tname, tmobile, taddress, trquest;
    Button tsubmit;
    SharedPreferences sharedPreferences;
    String shopnam;
    TextView shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_request);
        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        shopnam = sharedPreferences.getString("SHOP", null);
        shop = findViewById(R.id.shopsname);
        tname = findViewById(R.id.names);
        tmobile = findViewById(R.id.phones);
        taddress = findViewById(R.id.address);
        trquest = findViewById(R.id.prescript);
        tsubmit = findViewById(R.id.addreques);

        shop.setText(shopnam);
        tsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Submitted your request", Toast.LENGTH_SHORT).show();

            }
        });
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_dots, menu);
            return true;

    }
    }

