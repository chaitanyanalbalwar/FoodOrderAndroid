package com.example.foodorder.Fragments.Tax.Model;

import java.util.ArrayList;

public class TaxModel {

    String id,taxTitle,displayName,taxAmount,taxDisc;
    ArrayList<TaxType> taxTypeArrayList;
    ArrayList<OrderType> orderTypeArrayList;


    public TaxModel(String id, String taxTitle, String displayName, String taxAmount, String taxDisc, ArrayList<TaxType> taxTypeArrayList, ArrayList<OrderType> orderTypeArrayList) {
        this.id = id;
        this.taxTitle = taxTitle;
        this.displayName = displayName;
        this.taxAmount = taxAmount;
        this.taxDisc = taxDisc;
        this.taxTypeArrayList = taxTypeArrayList;
        this.orderTypeArrayList = orderTypeArrayList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaxTitle() {
        return taxTitle;
    }

    public void setTaxTitle(String taxTitle) {
        this.taxTitle = taxTitle;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getTaxDisc() {
        return taxDisc;
    }

    public void setTaxDisc(String taxDisc) {
        this.taxDisc = taxDisc;
    }

    public ArrayList<TaxType> getTaxTypeArrayList() {
        return taxTypeArrayList;
    }

    public void setTaxTypeArrayList(ArrayList<TaxType> taxTypeArrayList) {
        this.taxTypeArrayList = taxTypeArrayList;
    }

    public ArrayList<OrderType> getOrderTypeArrayList() {
        return orderTypeArrayList;
    }

    public void setOrderTypeArrayList(ArrayList<OrderType> orderTypeArrayList) {
        this.orderTypeArrayList = orderTypeArrayList;
    }
}
