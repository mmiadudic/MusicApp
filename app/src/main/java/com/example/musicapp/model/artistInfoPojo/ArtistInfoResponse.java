package com.example.musicapp.model.artistInfoPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ArtistInfoResponse {

    @SerializedName("artist")
    @Expose
    public Artist artist;

}


