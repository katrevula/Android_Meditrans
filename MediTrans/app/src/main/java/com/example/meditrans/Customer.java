package com.example.meditrans;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        progressBar=findViewById(R.id.progress);
        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
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
