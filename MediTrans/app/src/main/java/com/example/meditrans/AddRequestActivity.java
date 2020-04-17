package com.example.meditrans;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddRequestActivity extends AppCompatActivity {
    EditText tname, tmobile, taddress, trquest;
    Button tsubmit;
    String shopnam;
    TextView shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_request);
        shop = findViewById(R.id.shopsname);
        tname = findViewById(R.id.names);
        tmobile = findViewById(R.id.phones);
        taddress = findViewById(R.id.address);
        trquest = findViewById(R.id.prescript);
        tsubmit = findViewById(R.id.addreques);

       // shop.setText(shopnam);
        tsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snam = tname.getText().toString();
                String smob = tmobile.getText().toString();
                String sadd = taddress.getText().toString();
                String sreq = trquest.getText().toString();
                if(snam.equals("")&&smob.equals("")&&sadd.equals("")&&sreq.equals("")) {
                    tname.setError("Enter your name here");
                    tmobile.setError("Enter your mobile number here");
                    taddress.setError("Enter your address here");
                    trquest.setError("Type your Request or Prescription");
                }
                else {
                    Toast.makeText(getApplicationContext(),"Submitted your request",Toast.LENGTH_SHORT).show();
//                    addrequests();
                }

            }
        });
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_dots, menu);
            return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.shome:
                Intent i =new Intent(getApplicationContext(),MediTrans.class);
                startActivity(i);
                return true;
            case R.id.about:
                i =new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(i);
                return true;
            case R.id.contact:
                i =new Intent(getApplicationContext(),ContactActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
