package com.example.meditrans;

public class AddReqClass {
    private String bname;
    private String bmobile;
    private String brequest;
    private String baddress;


    public AddReqClass(String bname, String bmobile, String baddress, String brequest) {
        this.bname = bname;
        this.bmobile = bmobile;
        this.brequest = brequest;
        this.baddress = baddress;
    }
    public AddReqClass() {

    }
    public String getBaddress() {
        return baddress;
    }


    public String getBname() {
        return bname;
    }



    public String getBmobile() {
        return bmobile;
    }



    public String getBrequest() {
        return brequest;
    }

    
}
