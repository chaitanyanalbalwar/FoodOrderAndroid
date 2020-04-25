package com.example.foodorder.Model;

public class OrderStatusModel {

    String name,time;
    Boolean Checked;

    public OrderStatusModel(String name, String time, Boolean Checked) {
        this.name = name;
        this.time = time;
        this.Checked = Checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getSetChecked() {
        return Checked;
    }

    public void setSetChecked(Boolean setChecked) {
        this.Checked = setChecked;
    }
}
