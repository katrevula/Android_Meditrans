package com.example.meditrans;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class MedicineDataAdapter extends RecyclerView.Adapter<MedicineDataAdapter.MedicineDataHolder> {

    MedicineDataActivity dashboard;
    List<MedicineData> medicineData;

    public MedicineDataAdapter(MedicineDataActivity dashboard, List<MedicineData> medicineData) {
        this.dashboard = dashboard;
        this.medicineData = medicineData;
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineDataHolder viewHolder, int i) {
        viewHolder.medName.setText(medicineData.get(i).getName());
        viewHolder.medCost.setText(medicineData.get(i).getCost());
        viewHolder.medDescription.setText(medicineData.get(i).getDescription());
    }

    @NonNull
    @Override
    public MedicineDataHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.medicine, viewGroup, false);
        return new MedicineDataHolder(itemView);
    }


    @Override
    public int getItemCount() {
        return medicineData.size();
    }

    public static class MedicineDataHolder extends RecyclerView.ViewHolder {

        TextView medName;
        TextView medCode;
        TextView medCost;
        TextView medShopname;
        TextView medDescription;
        TextView medAvaliable;
        CardView cardView;
        View view;
        private Listener listener;

        public MedicineDataHolder(@NonNull View itemView) {
            super(itemView);


//            cardView = itemView.findViewById(R.id.card1);
            medName = itemView.findViewById(R.id.medicineName);
            medCost = itemView.findViewById(R.id.medicineCost);
            medDescription = itemView.findViewById(R.id.medicineDescription);

        }


        public interface Listener {
            void onItemClick(View view, int position);

            void onItemLongClick(View view, int position);
        }
    }


}