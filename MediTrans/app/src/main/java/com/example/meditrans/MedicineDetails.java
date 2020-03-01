package com.example.meditrans;

import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;


public class MedicineDetails extends AppCompatActivity implements SearchView.OnQueryTextListener {
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
