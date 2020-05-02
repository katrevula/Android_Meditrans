package com.example.meditrans;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustRecyler extends AppCompatActivity {
    FirebaseAuth mFirebaseAuth;
    String user_id;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button NextProcessBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerrecyler);
        recyclerView = findViewById(R.id.custRecyler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        recyclerView.setLayoutManager(layoutManager);
        CharSequence mTitle = getTitle();
        mTitle = "Cart";
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



    }

    @Override
    protected void onStart() {
        super.onStart();

//        user_id = mFirebaseAuth.getCurrentUser().getUid();
        user_id =  "ylRI8cFLJ3UpRWYaX0zVTOkAeYD2";

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("userdata");


        FirebaseRecyclerOptions<SignupDetails> options = new FirebaseRecyclerOptions.Builder<SignupDetails>()
                .setQuery(cartListRef
                        , SignupDetails.class).build();

        FirebaseRecyclerAdapter<SignupDetails, ViewHolder> adapter =
                new FirebaseRecyclerAdapter<SignupDetails, ViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull final SignupDetails model) {
//                        holder.owner.setText(model.getOwnerName());
//                        holder.email.setText(model.getEmail());
//                        holder.uname.setText(model.getUserName());
//                        holder.addr.setText(model.getShopAddress());
//                        holder.phone.setText(model.getPhone());
                        holder.location.setText(model.getLocation());
                        holder.name.setText(model.getShopName());
//                        holder.time.setText(model.getTime());

                    }

                    @NonNull
                    @Override
                    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customermodel, parent, false);
                        ViewHolder holder = new ViewHolder(view);
                        return holder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
