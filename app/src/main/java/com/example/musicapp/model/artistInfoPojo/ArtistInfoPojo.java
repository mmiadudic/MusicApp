package com.example.musicapp.model.artistInfoPojo;

public class ArtistInfoPojo {
    private String artistName;
    private String artistBio;

    public ArtistInfoPojo(String artistName, String artistBio) {
        this.artistName = artistName;
        this.artistBio = artistBio;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistBio() {
        return artistBio;
    }
}
