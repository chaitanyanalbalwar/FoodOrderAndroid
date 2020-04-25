package com.example.foodorder.Fragments.Tax.Model;

public class OrderType {

    String id,orderType;

    public OrderType(String id, String orderType) {
        this.id = id;
        this.orderType = orderType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
