package com.example.meditrans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MedicineDataActivity extends AppCompatActivity {

    List<MedicineData> medicineDataList = new ArrayList<>();
    ArrayList<MedicineData> shopnamesEmailList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore firebaseFireStore;
    MedicineDataAdapter medicineDataAdapter;
    public String shopnamesEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_details_1);

        firebaseFireStore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.medicineDataRecycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        Intent intent = getIntent();
        shopnamesEmail = intent.getStringExtra("shopnamesEmail");
//        startActivity(intent);
        retrieveData();
    }

    ArrayList<MedicineData> medicineDataList11 = new ArrayList<>();

    private void retrieveData() {
        firebaseFireStore.collection("Medicines").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                medicineDataList.clear();

                for (DocumentSnapshot medInformation : task.getResult()) {
                    medicineDataList.add(new MedicineData(medInformation.getString("name"), medInformation.getString("code"), medInformation.getString("cost"), medInformation.getString("shopname"), medInformation.getString("description"), medInformation.getString("avaliable")));

                }

                for (MedicineData data : medicineDataList) {

                    if (data.getShopname().equals(shopnamesEmail))
                        shopnamesEmailList.add(data);

                }

                medicineDataAdapter = new MedicineDataAdapter(MedicineDataActivity.this, shopnamesEmailList);
                recyclerView.setAdapter(medicineDataAdapter);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(MedicineDataActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void addRequest(View view){


        Intent intent = new Intent(getApplicationContext(), AddRequestActivity.class);
        intent.putExtra("shopnamesEmail" ,shopnamesEmail) ;
        startActivity(intent);

    }


}
