package com.example.meditrans;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

class MedicineDataHolder extends RecyclerView.ViewHolder {

    TextView medName;
    //        TextView medCode;
    TextView medCost;
    //        TextView medShopname;
    TextView medDescription;
    //        TextView medAvaliable;
    CardView cardView;

    public MedicineDataHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card1);
        medName = itemView.findViewById(R.id.medicineName);
        medCost = itemView.findViewById(R.id.medicineCost);
        medDescription = itemView.findViewById(R.id.medicineDescription);


    }


}