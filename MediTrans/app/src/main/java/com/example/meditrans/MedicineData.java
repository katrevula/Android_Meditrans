package com.example.meditrans;

import android.widget.TextView;

public class MedicineData {

    String medName;
    String medCode;
    String medCost;
    String medShopname;
    String medDescription;
    String medAvaliable;


    public MedicineData() {

        // Empty Constructor needed
    }

    public MedicineData(String medName, String medCode, String medCost, String medShopname, String medDescription, String medAvaliable) {
        this.medName = medName;
        this.medCode = medCode;
        this.medCost = medCost;
        this.medShopname = medShopname;
        this.medDescription = medDescription;
        this.medAvaliable = medAvaliable;
    }

    public String getMedName() {
        return medName;
    }

    public String getMedCode() {
        return medCode;
    }

    public String getMedCost() {
        return medCost;
    }

    public String getMedShopname() {
        return medShopname;
    }

    public String getMedDescription() {
        return medDescription;
    }

    public String getMedAvaliable() {
        return medAvaliable;
    }
}
