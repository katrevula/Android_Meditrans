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







}
