package com.example.musicapp.model.artistPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtistResponse {

    @SerializedName("artists")
    @Expose
    public Artists artists;

}