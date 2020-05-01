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
    //    SharedPreferences sharedPreferences;
    String userids;
    FirebaseAuth firebaseAuth;
    SignupDetails userdata;





//    private AwesomeValidation awesomeValidation;

//    FirebaseAuth mFirebaseAuth;
//    //    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://meditrans-78e4b.firebaseio.com/");;
//    DatabaseReference databaseReference;
//    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG", "Value is: Step 1 " );
        super.onCreate(savedInstanceState);
        Log.d("TAG", "Value is: Step 2 " );
        setContentView(R.layout.activity_med_update);
        Log.d("TAG", "Value is: Step 3 " );



//        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
//        userids = sharedPreferences.getString("USER",null);
        e1 = findViewById(R.id.shopName);
        e1.setEnabled(false);
        e2 = findViewById(R.id.userib);
        e2.setEnabled(false);
        e3 = findViewById(R.id.password);
        e3.setEnabled(false);
        e4 = findViewById(R.id.shopownername);
        e4.setEnabled(false);
        e5 = findViewById(R.id.phone);
        e5.setEnabled(false);
        e6 = findViewById(R.id.email);
        e6.setEnabled(false);
        e7 = findViewById(R.id.shopAddress);
        e7.setEnabled(false);
        e8 = findViewById(R.id.city);
        e8.setEnabled(false);
        e9 = findViewById(R.id.time);
        e9.setEnabled(false);
        r1 = findViewById(R.id.rgj);
        rb1 = findViewById(R.id.rbak);
        rb2 = findViewById(R.id.rbbl);
        b1 = findViewById(R.id.bim);
        Log.d("TAG", "Value is: Step 4 " );
        getdetails();


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

    String uid = firebaseAuth.getInstance().getCurrentUser().getUid();

    public void showData(DataSnapshot dataSnapshot) {

        Log.d("TAG", "Value is: Step showData " );

        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            SignupDetails userdata = new SignupDetails();
            Log.d("TAG", "Value is: Step showData for loop " );

            userdata = ds.child(uid).getValue(SignupDetails.class);
            Log.d("TAG", "Value is: Step showData user data" );
            System.out.println(userdata.getShopName() + " kvkvkvkvkvkvkvkvkv");
        }
//
//        e1.setText(userdata.getShopName());
//        e2.setText(userdata.getUserName());
//        e3.setText(userdata.getPassword());
//        e4.setText(userdata.getOwnerName());
//        e5.setText(userdata.getPhone());
//        e9.setText(userdata.getEmail());
//        e6.setText(userdata.getShopAddress());
//        e7.setText(userdata.getLocation());
//        e8.setText(userdata.getTime());
//
//        e9.setText(userdata.getUserName());


    }

    public void getdetails() {
        Log.d("TAG", "Value is: Step 5 " );
//        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());


//        String uid = firebaseAuth.getInstance().getCurrentUser().getUid();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

//        databaseReference = FirebaseDatabase.getInstance().getReference().child("userdata").child(user_id);


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d("TAG", "Value is: Step 6 " );
                showData(dataSnapshot);
                Log.d("TAG", "Value is: Step 7 " );
//
//                Log.d("TAG", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });


//        String serverurl = API.getmedico;
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, serverurl, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
////                progressBar.setVisibility(View.GONE);
//
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONArray jsonArray = jsonObject.getJSONArray("medicine");
//
//                    for (int i = 0; i < jsonArray.length(); i++) {
//
//                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
////                        String eid=jsonObject1.getString("id");
//                        String mshopname = jsonObject1.getString("shopname");
//                        String muserid = jsonObject1.getString("userid");
//                        String mpass=jsonObject1.getString("password");
//                        String mowner=jsonObject1.getString("ownername");
//                        String mmobile=jsonObject1.getString("mobile");
//                        String memail=jsonObject1.getString("email");
//                        String maddress=jsonObject1.getString("address");
//                        String mcity=jsonObject1.getString("city");
//                        String mtiming=jsonObject1.getString("timing");
//                        String mdoordel=jsonObject1.getString("doordelivery");
//                        e1.setText(mshopname);
//                        e2.setText(muserid);
//                        e3.setText(mpass);
//                        e4.setText(mowner);
//                        e5.setText(mmobile);
//                        e9.setText(memail);
//                        e6.setText(maddress);
//                        e7.setText(mcity);
//                        e8.setText(mtiming);
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
////                progressBar.setVisibility(View.GONE);
//                VolleyLog.d("Main", "Error: " + error.getMessage());
//                Log.d("Main", "" + error.getMessage() + "," + error.toString());
//
//
//            }
//        }) {
//            @Override
//            public Map<String, String> getParams() {
////                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
//                Map<String,String> data= new HashMap<String, String>();//to bind group of data
//                //to insert data from edit feilds into table feilds
//                data.put("userid",userids);
//
//                return data;
//            }
//
//        };
////        progressBar.setVisibility(View.VISIBLE);
//        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
//        queue.add(stringRequest);

    }
}
