package com.example.meditrans;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MedViewMed extends AppCompatActivity {
    TableLayout tl1;
    TextView tv0, tv1, tv2, tv3, tv4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_view_med);
        tl1 = findViewById(R.id.viewmed);
        getfeedback();
    }
    public void getfeedback() {
        TableRow row = new TableRow(getApplicationContext());
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);
        tv0 = new TextView(getApplicationContext());
        tv1 = new TextView(getApplicationContext());
        tv2 = new TextView(getApplicationContext());
        tv3 = new TextView(getApplicationContext());
        tv4 = new TextView(getApplicationContext());
        tv0.setText("f109");
        tv0.setTextColor(Color.BLACK);
        tv0.setPadding(5, 5, 5, 5);
        tv0.setBackgroundColor(R.drawable.cell_shape3);
        tv1.setText("dolo");
        tv1.setTextColor(Color.BLACK);
        tv1.setPadding(5, 5, 5, 5);
        tv1.setBackgroundResource(R.drawable.cell_shape3);
        tv2.setText("123");
        tv2.setTextColor(Color.BLACK);
        tv2.setPadding(5, 5, 5, 5);
        tv2.setBackgroundResource(R.drawable.cell_shape3);
        tv3.setText("70");
        tv3.setTextColor(Color.BLACK);
        tv3.setPadding(5, 5, 5, 5);
        tv3.setBackgroundResource(R.drawable.cell_shape3);
        tv4.setText("available");
        tv4.setTextColor(Color.BLACK);
        tv4.setPadding(5, 5, 5, 5);
        tv4.setBackgroundResource(R.drawable.cell_shape3);
        row.addView(tv0);
        row.addView(tv1);
        row.addView(tv2);
        row.addView(tv3);
        row.addView(tv4);
        tl1.addView(row);

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
}