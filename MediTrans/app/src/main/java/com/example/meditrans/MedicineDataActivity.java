package com.example.meditrans;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MedicineDataActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference mediCollectionReference = db.collection("Medicines");
    private MedicineDataAdapter adapter;
    SignupDetails userData;
    FirebaseAuth mFirebaseAuth;
    //    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://meditrans-78e4b.firebaseio.com/");;
    DatabaseReference databaseReference;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();


    public String shopnamesEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        shopnamesEmail = intent.getStringExtra("shopnamesEmail");


        databaseReference = FirebaseDatabase.getInstance().getReference().child("userdata");




        setContentView(R.layout.activity_medicine_details_1);

        setUpRecyclerView();

    }

    private void setUpRecyclerView() {

        Query query = mediCollectionReference.orderBy("priority", Query.Direction.DESCENDING);
//        mediCollectionReference.where

        FirestoreRecyclerOptions<MedicineData> options = new FirestoreRecyclerOptions.Builder<MedicineData>()
                .setQuery(query, MedicineData.class)
                .build();
        adapter = new MedicineDataAdapter(options);
        RecyclerView recyclerView = findViewById(R.id.medicineDataRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }


    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }


}
