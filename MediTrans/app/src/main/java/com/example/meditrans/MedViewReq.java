package com.example.meditrans;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;


public class MedViewReq extends AppCompatActivity {
    RecyclerView recyclerView;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_view_req);
        recyclerView = findViewById(R.id.recyviewreq);
        getrequest();
    }
    public void getrequest() {
        AddReqClass jobsBean1 = new AddReqClass();
        jobsBean1.setBname("kavya");
    }