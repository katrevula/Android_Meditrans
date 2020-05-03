package com.example.meditrans;

public class RequestData {

    String tname;
    String tmobile;
    String taddress;
    String trquest;
    String tshopNAME;



    public RequestData() {
    }

    public RequestData(String tname, String tmobile, String taddress, String trquest) {
        this.tname = tname;
        this.tmobile = tmobile;
        this.taddress = taddress;
        this.trquest = trquest;
    }

    public RequestData(String tname, String tmobile, String taddress, String trquest, String tshopNAME) {
        this.tname = tname;
        this.tmobile = tmobile;
        this.taddress = taddress;
        this.trquest = trquest;
        this.tshopNAME = tshopNAME;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTmobile() {
        return tmobile;
    }

    public void setTmobile(String tmobile) {
        this.tmobile = tmobile;
    }

    public String getTaddress() {
        return taddress;
    }

    public void setTaddress(String taddress) {
        this.taddress = taddress;
    }

    public String getTrquest() {
        return trquest;
    }

    public void setTrquest(String trquest) {
        this.trquest = trquest;
    }
}
