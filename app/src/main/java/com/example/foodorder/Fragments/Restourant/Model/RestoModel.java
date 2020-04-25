package com.example.foodorder.Fragments.Restourant.Model;

public class RestoModel {

    String id, name,displayName,fileName;

    public RestoModel(String id, String name, String displayName, String fileName) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.fileName = fileName;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
