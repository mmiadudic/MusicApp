package com.example.musicapp.model;

public class SearchItemData {
    public String name;
    String image;

    public SearchItemData(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
