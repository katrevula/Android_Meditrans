package com.example.meditrans;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;


public class MedViewReq extends AppCompatActivity {
    RecyclerView recyclerView;
    ViewRequestAdapter viewRequestAdapter;
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
        jobsBean1.setBmobile("6605349686");
        jobsBean1.setBaddress("maryville");
        jobsBean1.setBrequest("fever");
        data.add(jobsBean1);
         }
    private class ViewRequestAdapter extends RecyclerView.Adapter<MedViewReq.ViewRequestAdapter.MyViewHolder> {
        List<AddReqClass> data;
        Context applicationContext;
    }