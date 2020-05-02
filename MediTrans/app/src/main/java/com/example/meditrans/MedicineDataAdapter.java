package com.example.meditrans;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class MedicineDataAdapter extends FirestoreRecyclerAdapter<MedicineData, MedicineDataAdapter.MedicineDataHolder> {

    public MedicineDataAdapter(@NonNull FirestoreRecyclerOptions<MedicineData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MedicineDataHolder holder, int position, @NonNull MedicineData model) {

        holder.medName.setText(model.getMedName());
        holder.medCost.setText(model.getMedCost());
        holder.medDescription.setText(model.getMedDescription());
    }

    @NonNull
    @Override
    public MedicineDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_medicine_details_1,parent,false);
        return new MedicineDataHolder(v);
    }

    class MedicineDataHolder extends RecyclerView.ViewHolder {

        TextView medName;
        TextView medCode;
        TextView medCost;
        TextView medShopname;
        TextView medDescription;
        TextView medAvaliable;

        public MedicineDataHolder(@NonNull View itemView) {
            super(itemView);
            medName = itemView.findViewById(R.id.medicineName);
            medCost = itemView.findViewById(R.id.medicineCost);
            medDescription = itemView.findViewById(R.id.medicineDescription);


        }
    }


}