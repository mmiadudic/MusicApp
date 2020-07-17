package com.example.musicapp.model;

public class ArtistItemData {
    public String name;
    private String listeners;
    private String playcount;
    private String image;

    public ArtistItemData(String name, String listeners, String playcount, String image) {
        this.name = name;
        this.listeners = listeners;
        this.playcount = playcount;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getListeners() {
        return listeners;
    }

    public String getPlaycount() {
        return playcount;
    }

    public String getImage() {
        return image;
    }
}