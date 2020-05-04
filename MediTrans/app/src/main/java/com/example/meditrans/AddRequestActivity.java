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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddRequestActivity extends AppCompatActivity {
    EditText tname, tmobile, taddress, trquest;
    Button tsubmit;
    String shopnam;
    TextView shop;
    DatabaseReference databaseReference;

    public String shopnamesEmail;
    private AwesomeValidation awesomeValidation;

    String userid;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth mFirebaseAuth;
    Boolean check = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_request);

        Log.d("TAG", "In activity Add rerquest ");
        Intent intent = getIntent();
        shopnamesEmail = intent.getStringExtra("shopnamesEmail");

        shop = findViewById(R.id.shopsname);
        tname = findViewById(R.id.names);
        tmobile = findViewById(R.id.phones);
        taddress = findViewById(R.id.address);
        trquest = findViewById(R.id.prescript);
        tsubmit = findViewById(R.id.addreques);

        shop.setText(shopnamesEmail);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.names,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);

        awesomeValidation.addValidation(this, R.id.phones,
                "^[6-9]{1}[0-9]{9}$", R.string.nameerror);


        awesomeValidation.addValidation(this, R.id.prescript,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);


        tsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String snam = tname.getText().toString();
//                String smob = tmobile.getText().toString();
//                String sadd = taddress.getText().toString();
//                String sreq = trquest.getText().toString();
//                 String tshopNAME = shopnamesEmail;
//                if (snam.equals("") && smob.equals("") && sadd.equals("") && sreq.equals("")) {
//                    tname.setError("Enter your name here");
//                    tmobile.setError("Enter your mobile number here");
//                    taddress.setError("Enter your address here");
//                    trquest.setError("Type your Request or Prescription");
//                } else {
////                    Toast.makeText(getApplicationContext(), "Submitted your request", Toast.LENGTH_SHORT).show();
//                     databaseReference = FirebaseDatabase.getInstance().getReference().child("requests");
//
//                    RequestData reqdata = new RequestData(snam, smob, sadd, sreq, tshopNAME);
//                    databaseReference.setValue(reqdata);
//                    Toast.makeText(getApplicationContext(), "Request Submitted", Toast.LENGTH_SHORT).show();
//                }

                getParamssss();


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

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
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

    public void getParamssss() {
        // Create a new user with a first and last name
        //To Read data from Edit fields and convert to string
        String snam = tname.getText().toString();
        String smob = tmobile.getText().toString();
        String sadd = taddress.getText().toString();
        String sreq = trquest.getText().toString();
        String tshopNAME = shopnamesEmail;

        if (snam.equals("") && smob.equals("") && sadd.equals("") && sreq.equals("")) {
            tname.setError("Enter your name here");
            tmobile.setError("Enter your mobile number here");
            taddress.setError("Enter your address here");
            trquest.setError("Type your Request or Prescription");
        } else {
            Map<String, String> data = new HashMap<String, String>();//to bind group of data

            data.put("name", snam);
            data.put("code", smob);
            data.put("cost", sadd);
            data.put("shopname", sreq);
            data.put("description", tshopNAME);


            FirebaseFirestore db = FirebaseFirestore.getInstance();
// Add a new document with a generated ID
            db.collection("Requests")
                    .add(data)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("TAG", "Requests ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("TAG", "Error adding document", e);
                        }
                    });
            Toast.makeText(getApplicationContext(), "Request Submitted", Toast.LENGTH_SHORT).show();

        }
        check = true;
        resetdata();


    }

    public void resetdata() {

        if (check) {


            tname.setText(null);
            tmobile.setText(null);
            taddress.setText(null);
            trquest.setText(null);

        }

    }

}
