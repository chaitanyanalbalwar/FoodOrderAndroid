package com.example.foodorder.Activities.Login.Model;

public class LoginModel implements ILogin{

    String Mobile;


    public LoginModel(String mobile) {
        this.Mobile = mobile;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }


    @Override
    public int checkUserValidity(String MobileNo){
        if (MobileNo==null|| !MobileNo.equals(getMobile())){
            return -1;
        }
        return 0;
    }
}
