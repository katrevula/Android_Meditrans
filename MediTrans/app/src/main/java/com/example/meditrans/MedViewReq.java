package com.example.meditrans;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

        public ViewRequestAdapter(List<AddReqClass> data, Context applicationContext) {
            this.applicationContext = applicationContext;
            this.data = data;
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewrequest_layout, parent, false);
            return new MyViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull final ViewRequestAdapter.MyViewHolder holder, final int position) {
            holder.sname.setText(data.get(position).getBname());
            holder.smobile.setText(data.get(position).getBmobile());
            holder.sdesript.setText(data.get(position).getBrequest());
            holder.addres.setText(data.get(position).getBaddress());
        }
        @Override
        public int getItemCount() {
            return data.size();

        }
        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView sname, smobile, addres, sdesript;
            ImageView scall;
            public MyViewHolder(View itemView) {
                super(itemView);
                sname = itemView.findViewById(R.id.name);
                smobile = itemView.findViewById(R.id.phnumber);
                sdesript = itemView.findViewById(R.id.descript);
                addres = itemView.findViewById(R.id.address);
//                scall = itemView.findViewById(R.id.called);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_dots, menu);
        return true;
    }

        }