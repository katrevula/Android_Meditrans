package com.example.meditrans;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
//import com.example.abhinaya.meditrans.Network.API;
//import com.example.abhinaya.meditrans.Network.VolleySingleton;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

//import com.basgeekball.awesomevalidation.AwesomeValidation;
//import com.basgeekball.awesomevalidation.ValidationStyle;

public class MedUpdate extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9;
    RadioGroup r1;
    RadioButton rb1, rb2;
    Button b1;
    SharedPreferences sharedPreferences;
    String userids;
   // private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_update);

        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
        userids = sharedPreferences.getString("USER",null);
        e1 = findViewById(R.id.sna);
        e1.setEnabled(false);
        e2 = findViewById(R.id.uib);
        e2.setEnabled(false);
        e3 = findViewById(R.id.pc);
        e3.setEnabled(false);
        e4 = findViewById(R.id.sond);
        e4.setEnabled(false);
        e5 = findViewById(R.id.mne);
        e5.setEnabled(false);
        e6 = findViewById(R.id.sag);
        e6.setEnabled(false);
        e7 = findViewById(R.id.lch);
        e7.setEnabled(false);
        e8 = findViewById(R.id.ti);
        e8.setEnabled(false);
        e9 = findViewById(R.id.ef);
        e9.setEnabled(false);
        r1 = findViewById(R.id.rgj);
        rb1 = findViewById(R.id.rbak);
        rb2 = findViewById(R.id.rbbl);
        b1 = findViewById(R.id.bim);


//        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);
//        awesomeValidation.addValidation(this, R.id.sn,
//                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation(this, R.id.ui,
//                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation(this, R.id.son,
//                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation(this, R.id.mn,
//                "^[6-9]{1}[0-9]{9}$", R.string.nameerror);
//        awesomeValidation.addValidation(this, R.id.lc,
//                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation(this, R.id.e,
//                Patterns.EMAIL_ADDRESS, R.string.nameerror);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent a = new Intent(getApplicationContext(), MedHome.class);
                startActivity(a);

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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
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
