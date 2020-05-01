package com.example.meditrans;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MedUpdate extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9;
    RadioGroup r1;
    RadioButton rb1, rb2;
    Button b1;
    DatabaseReference databaseReference;
       FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG", "Value is: Step 1 " );
        super.onCreate(savedInstanceState);
        Log.d("TAG", "Value is: Step 2 " );
        setContentView(R.layout.activity_med_update);
        Log.d("TAG", "Value is: Step 3 " );
        r1 = findViewById(R.id.rgj);
        rb1 = findViewById(R.id.rbak);
        rb2 = findViewById(R.id.rbbl);
        b1 = findViewById(R.id.bim);
        e1 = findViewById(R.id.shopname);
        e2 = findViewById(R.id.userib);
        e3 = findViewById(R.id.password);
        e4 = findViewById(R.id.shopownername);
        e5 = findViewById(R.id.phone);
        e6 = findViewById(R.id.email);
        e7 = findViewById(R.id.shopAddress);
        e8 = findViewById(R.id.city);
        e9 = findViewById(R.id.time);
        String user_id =firebaseAuth.getInstance().getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("userdata").child(user_id);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String shopName = dataSnapshot.child("shopName").getValue().toString();
                String userID = dataSnapshot.child("userName").getValue().toString();
                String password = dataSnapshot.child("password").getValue().toString();
                String shopOwner = dataSnapshot.child("ownerName").getValue().toString();
                String city = dataSnapshot.child("location").getValue().toString();
                String email = dataSnapshot.child("email").getValue().toString();
                String phonenumber = dataSnapshot.child("phone").getValue().toString();
                String address = dataSnapshot.child("shopAddress").getValue().toString();
                String time = dataSnapshot.child("time").getValue().toString();
                e1.setText(shopName);
                e2.setText(userID);
                e3.setText(password);
                e4.setText(shopOwner);
                e5.setText(phonenumber);
                e6.setText(email);
                e7.setText(address);
                e8.setText(city);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        Log.d("TAG", "Value is: Step 4 " );
//        getdetails();
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

