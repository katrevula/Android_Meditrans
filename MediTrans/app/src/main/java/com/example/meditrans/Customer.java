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
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Customer  extends AppCompatActivity implements SearchView.OnQueryTextListener {
    int id;
    RecyclerView recyclerView;
    recyclerAdapter madapter;
    ProgressBar progressBar;
    List<Bean> data = new ArrayList<>();
    SearchView editsearch;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        progressBar = findViewById(R.id.progress);
        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
        recyclerView = findViewById(R.id.recycler);
        getfeedback();

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

    public void getfeedback() {
        //request for getting data
        data.clear();
        Bean Bean1 = new Bean();
        Bean1.setShopname("Walgreens");
        Bean1.setShopaddress("Maryville");
        Bean1.setUserid("15021");
        data.add(Bean1);

        madapter = new recyclerAdapter(data, getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(madapter);
    }

    public class recyclerAdapter extends RecyclerView.Adapter<Customer.recyclerAdapter.MyViewHolder> {
        List<Bean> horizontalList;
        Context context;

        recyclerAdapter(List<Bean> horizontalList, Context context) {
            this.horizontalList = horizontalList;
            this.context = context;
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

            holder.st1.setText(horizontalList.get(position).getShopname());
            holder.st2.setText(horizontalList.get(position).getShopaddress());
            holder.cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String shops = horizontalList.get(position).getUserid();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("SHOP", shops);
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(), MedicineDetails.class);
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }

        public void filter(String text) {
            List<Bean> filterdNames = new ArrayList<>();
            //looping through existing elements
            for (Bean s: horizontalList ) {
                //if the existing elements contains the search input
                if (s.getShopname().toLowerCase().contains(text.toLowerCase())) {
                    //adding the element to filtered list
                    filterdNames.add(s);
                }
            }
            //calling a method of the adapter class and passing the filtered list
            madapter.filterList(filterdNames);
        }
}