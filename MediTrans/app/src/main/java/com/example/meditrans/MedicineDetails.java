package com.example.meditrans;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MedicineDetails extends AppCompatActivity  {
    int id;
    RecyclerView recyclerView;
    MedicineAdapter aadapter;
    Button addreq;
    List<Bean> data = new ArrayList<>();
    ProgressBar progressBar;
    SearchView searchViews;
    SharedPreferences sharedPreferences;
    String shopnames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_details);
        progressBar=findViewById(R.id.progress);
        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
        shopnames = sharedPreferences.getString("SHOP",null);
        Toast.makeText(getApplicationContext(),shopnames,Toast.LENGTH_SHORT).show();
        recyclerView = findViewById(R.id.recycl);
        searchViews = findViewById(R.id.searchView);
//        searchViews.setOnQueryTextListener(this);

        //    getdetails();

        addreq = findViewById(R.id.addrequest);
        addreq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AddRequestActivity.class);
                startActivity(i);
            }
        });

    }

    public void getdetails() {
        data.clear();
        Bean jobsBean1 = new Bean();
        jobsBean1.setId("1234");
        jobsBean1.setMedname("dolo");
        jobsBean1.setMedcost("90");
    }
    private class MedicineAdapter extends RecyclerView.Adapter<MedicineDetails.MedicineAdapter.MyViewHolder> {
        List<Bean> horizontalList;
        Context context;

        MedicineAdapter(List<Bean> horizontalList, Context context) {
            this.horizontalList = horizontalList;
            this.context = context;
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            holder.st5.setText(horizontalList.get(position).getMedname());
            holder.st6.setText(horizontalList.get(position).getMedcost());
            holder.st7.setText(horizontalList.get(position).getMeddesc());

        }

        @Override
        public int getItemCount()
        {
            return horizontalList.size();
        }
        public void filter(String text) {
            List<Bean> filterdNames = new ArrayList<>();
            //looping through existing elements
            for (Bean s: horizontalList ) {
                //if the existing elements contains the search input
                if (s.getMedname().toLowerCase().contains(text.toLowerCase())) {
                    //adding the element to filtered list
                    filterdNames.add(s);
                }
            }
            //calling a method of the adapter class and passing the filtered list
            aadapter.filterList(filterdNames);
        }
        public void filterList(List<Bean> data) {
            this.horizontalList = data;
            notifyDataSetChanged();
        }
        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView st5, st6,st7;
            MyViewHolder(View view) {
                super(view);
                st5 = view.findViewById(R.id.t4);
                st6 = view.findViewById(R.id.t5);
                st7 = view.findViewById(R.id.t6);
            }
        }
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





}
