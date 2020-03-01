package com.example.meditrans;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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
    private class MedicineAdapter extends RecyclerView.Adapter<MedicineDetails.MedicineAdapter.MyViewHolder> {
        List<Bean> horizontalList;
        Context context;

        MedicineAdapter(List<Bean> horizontalList, Context context) {
            this.horizontalList = horizontalList;
            this.context = context;
        }
        





}
