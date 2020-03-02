package com.example.meditrans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
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
            switch (item.getItemId())
            {
                case android.R.id.home:
                    onBackPressed();
                    finish();
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


