package com.example.meditrans;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MedAdd extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5;
    RadioGroup rg;
    RadioButton rba,rbb;
    Button b ;
    //SharedPreferences sharedPreferences;
    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_add);
//        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
//        userid = sharedPreferences.getString("USER",null);
        et1=findViewById(R.id.mename);
        et2=findViewById(R.id.mecode);
        et3=findViewById(R.id.mecost);
        et4=findViewById(R.id.meshop);
        et4.setText(userid);
        et4.setEnabled(false);
        et5=findViewById(R.id.medes);
        rg=findViewById(R.id.radioGroup);
        rba=findViewById(R.id.rbuttonc);
        rbb=findViewById(R.id.rbuttond);
        b=findViewById(R.id.bj);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Medicine added", Toast.LENGTH_SHORT).show();


                String medname = et1.getText().toString();
               String medcode = et2.getText().toString();
                String medcost = et3.getText().toString();
                String medshop=et4.getText().toString();
                String meddes=et5.getText().toString();

                    if(medname.equals("")&&medcode.equals("")&&medcost.equals("")&&medshop.equals("")&&meddes.equals("")){
                        et1.setError("Not Empty");
                        et2.setError("Not Empty");
                        et3.setError("Not Empty");
                        et4.setError("Not Empty");
                        et5.setError("Not Empty");

                }else{
                    int selectedId=rg.getCheckedRadioButtonId();
                    rba=(RadioButton)findViewById(selectedId);
                               supload();
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
        // Handle item selection
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