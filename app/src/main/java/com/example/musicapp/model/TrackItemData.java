package com.example.musicapp.model;

public class TrackItemData {

    private String name;
    private String listeners;
    private String playcount;
    private String image;
    private String artistName;

    public TrackItemData(String name, String listeners, String playcount, String image, String artistName) {
        this.name = name;
        this.listeners = listeners;
        this.playcount = playcount;
        this.image = image;
        this.artistName = artistName;
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

    public String getArtistName() { return artistName; }

}
