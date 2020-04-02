package com.example.meditrans;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

public class MedViewMed extends AppCompatActivity {
    TableLayout tl1;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_view_med);
        tl1 = findViewById(R.id.viewmed);

}
