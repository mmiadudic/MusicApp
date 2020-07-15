package com.example.musicapp.model.searchPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistMatches {
    @SerializedName("artist")
    @Expose
    public List<Artist> artist = null;
}
