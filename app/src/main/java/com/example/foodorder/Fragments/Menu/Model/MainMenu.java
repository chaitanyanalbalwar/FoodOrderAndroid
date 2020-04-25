package com.example.foodorder.Fragments.Menu.Model;

import java.util.ArrayList;

public class MainMenu {

    String id,name,shortCode,price,description,onlineDisplayName,avilable;
    ArrayList<SubMenu>  subMenu;


    public MainMenu(String id, String name, String shortCode, String price, String description, String onlineDisplayName, String avilable, ArrayList<SubMenu> subMenu) {
        this.id = id;
        this.name = name;
        this.shortCode = shortCode;
        this.price = price;
        this.description = description;
        this.onlineDisplayName = onlineDisplayName;
        this.avilable = avilable;
        this.subMenu = subMenu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOnlineDisplayName() {
        return onlineDisplayName;
    }

    public void setOnlineDisplayName(String onlineDisplayName) {
        this.onlineDisplayName = onlineDisplayName;
    }

    public String getAvilable() {
        return avilable;
    }

    public void setAvilable(String avilable) {
        this.avilable = avilable;
    }

    public ArrayList<SubMenu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(ArrayList<SubMenu> subMenu) {
        this.subMenu = subMenu;
    }
}
