package com.example.foodorder.Fragments.Categeorymenu.Model;

public class CategeoryModel {

    String id,name,displayName,quality,fileName;

    public CategeoryModel(String id, String name, String displayName, String quality, String fileName) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.quality = quality;
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

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
