package com.example.meditrans;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
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
        mTitle = "Pharmacies";
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
//        user_id =  "ylRI8cFLJ3UpRWYaX0zVTOkAeYD2";

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("userdata");


        FirebaseRecyclerOptions<SignupDetails> options = new FirebaseRecyclerOptions.Builder<SignupDetails>()
                .setQuery(cartListRef
                        , SignupDetails.class).build();

        FirebaseRecyclerAdapter<SignupDetails, CusViewHolder> adapter =
                new FirebaseRecyclerAdapter<SignupDetails, CusViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull final CusViewHolder holder, final int position, @NonNull final SignupDetails model) {
//                        holder.owner.setText(model.getOwnerName());
//                        holder.email.setText(model.getEmail());
//                        holder.uname.setText(model.getUserName());
//                        holder.addr.setText(model.getShopAddress());
//                        holder.phone.setText(model.getPhone());
                        holder.location.setText(model.getLocation());
                        holder.name.setText(model.getShopName());

//                        holder.time.setText(model.getTime());




                        holder.cardView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

//                                int shopPosition = holder.getPosition();
                                String shopnamesinholder = model.getEmail();




//                                String shops = horizontalList.get(position).getUserid();
//                                SharedPreferences.Editor editor = sharedPreferences.edit();
//                                editor.putString("SHOP", shops);
//                                editor.commit();

                                Intent intent = new Intent(getApplicationContext(), MedicineDataActivity.class);
                                intent.putExtra("shopnamesEmail" ,shopnamesinholder) ;
                                startActivity(intent);
                            }
                        });



                    }

                    @NonNull
                    @Override
                    public CusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customermodel, parent, false);
                        CusViewHolder holder = new CusViewHolder(view);
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
