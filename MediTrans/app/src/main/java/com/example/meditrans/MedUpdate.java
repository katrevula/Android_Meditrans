package com.example.meditrans;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MedUpdate extends AppCompatActivity {

    TextView shpnnme, usrid, psswrd, ownrname, phn, email, shpaddrs, cty, tme;
    RadioGroup r1;
    RadioButton rb1, rb2;
    Button b1;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_update);
        r1 = findViewById(R.id.rgj);
        rb1 = findViewById(R.id.rbak);
        rb2 = findViewById(R.id.rbbl);
        b1 = findViewById(R.id.bim);
        shpnnme = findViewById(R.id.shopname);
        usrid = findViewById(R.id.userid);
        psswrd = findViewById(R.id.password);
        ownrname = findViewById(R.id.shopownername);
        phn = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        shpaddrs = findViewById(R.id.shopAddress);
        cty = findViewById(R.id.city);
        tme = findViewById(R.id.time);
        String user_id = firebaseAuth.getInstance().getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("userdata").child(user_id);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String shopName = dataSnapshot.child("shopName").getValue().toString();
                String userID = dataSnapshot.child("userName").getValue().toString();
                String password = dataSnapshot.child("password").getValue().toString();
                String shopOwner = dataSnapshot.child("ownerName").getValue().toString();
                String city = dataSnapshot.child("location").getValue().toString();
                String usremail = dataSnapshot.child("email").getValue().toString();
                String phonenumber = dataSnapshot.child("phone").getValue().toString();
                String address = dataSnapshot.child("shopAddress").getValue().toString();
                String time = dataSnapshot.child("time").getValue().toString();
                shpnnme.setText(shopName);
                Log.d("hhhhhh","hhhhhh" +shopName);
                usrid.setText(userID);
                psswrd.setText(password);
                ownrname.setText(shopOwner);
                phn.setText(phonenumber);
                email.setText(usremail);
                shpaddrs.setText(address);
                cty.setText(city);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("error","Database error"+databaseError);
            }
        });

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
                Intent i = new Intent(getApplicationContext(), MediTrans.class);
                startActivity(i);
                return true;
            case R.id.about:
                i = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(i);
                return true;
            case R.id.contact:
                i = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

