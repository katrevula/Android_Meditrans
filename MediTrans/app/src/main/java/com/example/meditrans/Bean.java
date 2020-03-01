package com.example.meditrans;

public class Bean {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Bean(String id) {
        this.id = id;
    }

    private String id;
    private String shopname;
    private String shopaddress;
    private String userid;
    private String password;
    private String medname;
    private String medcode;
    private String medcost;
    private String meddesc;
    public String getMedname() {
        return medname;
    }



    public String getMedcode() {
        return medcode;
    }



    public String getMedcost() {
        return medcost;
    }



    public String getMeddesc() {
        return meddesc;
    }



    public String getUserid() {
        return userid;
    }


    public void setMedname(String medname) {
        this.medname = medname;
    }



    public void setMedcode(String medcode) {
        this.medcode = medcode;
    }



    public void setMedcost(String medcost) {
        this.medcost = medcost;
    }



    public void setMeddesc(String meddesc) {
        this.meddesc = meddesc;
    }



    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Bean(String shopname, String shopaddress, String username, String password) {
        this.shopname = shopname;
        this.shopaddress = shopaddress;
        this.userid = username;
        this.password = password;
    }
    public String getUsername() {
        return userid;
    }

    public String getPassword() {
        return password;
    }










}
