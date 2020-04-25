package com.example.foodorder.Model;

public class CartItemModel {

    String itemName,price,addOns;

    public CartItemModel(String itemName, String price, String addOns) {
        this.itemName = itemName;
        this.price = price;
        this.addOns = addOns;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddOns() {
        return addOns;
    }

    public void setAddOns(String addOns) {
        this.addOns = addOns;
    }
}
