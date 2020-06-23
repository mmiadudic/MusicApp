package com.example.musicapp.model.trackPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrackResponse {

    @SerializedName("tracks")
    @Expose
    public Tracks tracks;
}
