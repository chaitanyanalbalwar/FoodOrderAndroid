package com.example.foodorder.Model;

public class HomeModel {

    String itemMainLogo,itemLogo,itemName,itemPrice;


    public HomeModel(String itemMainLogo, String itemLogo, String itemName, String itemPrice) {
        this.itemMainLogo = itemMainLogo;
        this.itemLogo = itemLogo;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemMainLogo() {
        return itemMainLogo;
    }

    public void setItemMainLogo(String itemMainLogo) {
        this.itemMainLogo = itemMainLogo;
    }

    public String getItemLogo() {
        return itemLogo;
    }

    public void setItemLogo(String itemLogo) {
        this.itemLogo = itemLogo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
