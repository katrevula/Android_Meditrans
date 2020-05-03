package com.example.meditrans;

import android.widget.TextView;

public class MedicineData {

    String name;
    String code;
    String cost;
    String shopname;
    String description;
    String avaliable;


    public MedicineData() {

        // Empty Constructor needed
    }

    public MedicineData(String shopname) {
        this.shopname = shopname;
    }

    public MedicineData(String name, String code, String cost, String shopname, String description, String avaliable) {
        this.name = name;
        this.code = code;
        this.cost = cost;
        this.shopname = shopname;
        this.description = description;
        this.avaliable = avaliable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }
}
