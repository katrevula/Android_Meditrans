package com.example.meditrans;

public class SignupDetails {
    private String shopName;
    private String userName;
    private String password;
    private String ownerName;
    private String phone;
    private String email;
    private String shopAddress;
    private String location;
    private String time;

    public SignupDetails(String shopName, String userName, String password, String ownerName, String phone, String email, String shopAddress, String location, String time) {
        this.shopName = shopName;
        this.userName = userName;
        this.password = password;
        this.ownerName = ownerName;
        this.phone = phone;
        this.email = email;
        this.shopAddress = shopAddress;
        this.location = location;
        this.time = time;

    }
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
