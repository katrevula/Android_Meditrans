package com.example.meditrans;


import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


public class MedAdd extends AppCompatActivity {
    EditText et1, et2, et3, et4, et5;
    RadioGroup rg;
    RadioButton rba, rbb;
    Button b;
    //SharedPreferences sharedPreferences;
    String userid;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth mFirebaseAuth;

    private AwesomeValidation awesomeValidation;


    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_add);
//        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
//        userid = sharedPreferences.getString("USER",null);

        String userid = mFirebaseAuth.getInstance().getCurrentUser().getEmail();

        et1 = findViewById(R.id.mename);
        et2 = findViewById(R.id.mecode);
        et3 = findViewById(R.id.mecost);
        et4 = findViewById(R.id.meshop);
        et4.setText(userid);
        et4.setEnabled(false);
        et5 = findViewById(R.id.medes);
        rg = findViewById(R.id.radioGroup);
        rba = findViewById(R.id.rbuttonc);
        rbb = findViewById(R.id.rbuttond);
        b = findViewById(R.id.bj);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.shopName,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Medicine added", Toast.LENGTH_SHORT).show();


                String medname = et1.getText().toString();
                String medcode = et2.getText().toString();
                String medcost = et3.getText().toString();
                String medshop = et4.getText().toString();
                String meddes = et5.getText().toString();

                if (medname.equals("") && medcode.equals("") && medcost.equals("") && medshop.equals("") && meddes.equals("")) {
                    et1.setError("Not Empty");
                    et2.setError("Not Empty");
                    et3.setError("Not Empty");
                    et4.setError("Not Empty");
                    et5.setError("Not Empty");

                } else {
                    int selectedId = rg.getCheckedRadioButtonId();
                    rba = (RadioButton) findViewById(selectedId);

                    getParamssss();
                }
            }


        });
    }


    public void showData(DataSnapshot dataSnapshot) {

        SignupDetails userdata = new SignupDetails();


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
        String smedname = et1.getText().toString();
        String smedcode = et2.getText().toString();
        String smedcost = et3.getText().toString();
        String smedshop = et4.getText().toString();
        String smeddes = et5.getText().toString();

        String sradiobutton = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        Map<String, String> data = new HashMap<String, String>();//to bind group of data
        //to insert data from edit feilds into table feilds
        data.put("name", smedname);
        data.put("code", smedcode);
        data.put("cost", smedcost);
        data.put("shopname", smedshop);
        data.put("description", smeddes);
        data.put("avaliable", sradiobutton);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
// Add a new document with a generated ID
        db.collection("Medicines")
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "Medicine ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });
    }


    private void supload() {
        //calling url
        String serverurl = "";
        //sending request to url for response Or Request Constructer with 4 parameters

        StringRequest sr = new StringRequest(Request.Method.POST, serverurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String res = jsonObject.getString("result");//result should be matched with url link response ie,{"result":"success"}
                    if (res.equals("success")) //array key
                    {
                        Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
                        et1.setText(null);
                        et2.setText(null);
                        et3.setText(null);
                        et4.setText(null);
                        et5.setText(null);


                    } else {
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    }


                } catch (Exception e) {
                    Log.e("ERROR", "Exception");
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Main", "Error: " + error.getMessage());
                Log.d("Main", "" + error.getMessage() + "," + error.toString());

            }
        }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                //To Read data from Edit fields and convert to string
                String smedname = et1.getText().toString();
                String smedcode = et2.getText().toString();
                String smedcost = et3.getText().toString();
                String smedshop = et4.getText().toString();
                String smeddes = et5.getText().toString();

                String sradiobutton = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                Map<String, String> data = new HashMap<String, String>();//to bind group of data
                //to insert data from edit feilds into table feilds
                data.put("name", smedname);
                data.put("code", smedcode);
                data.put("cost", smedcost);
                data.put("shopname", smedshop);
                data.put("description", smeddes);
                data.put("avaliable", sradiobutton);
                return data;
            }
        };
    }

    private void shareApplication() {
        ApplicationInfo app = getApplicationContext().getApplicationInfo();
        String filePath = app.sourceDir;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");

        // Append file and send Intent
        File originalApk = new File(filePath);
        try {
            //Make new directory in new location
            File tempFile = new File(getExternalCacheDir() + "/ExtractedApk");
            //If directory doesn't exists create new
            if (!tempFile.isDirectory())
                if (!tempFile.mkdirs())
                    return;
            //Get application's name and convert to lowercase
            tempFile = new File(tempFile.getPath() + "/" + getString(app.labelRes).replace(" ", "").toLowerCase() + ".apk");
            //If file doesn't exists create new
            if (!tempFile.exists()) {
                if (!tempFile.createNewFile()) {
                    return;
                }
            }
            InputStream in = new FileInputStream(originalApk);
            OutputStream out = new FileOutputStream(tempFile);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            System.out.println("File copied.");
            //Open share dialog
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));
            startActivity(Intent.createChooser(intent, "Share app via"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
