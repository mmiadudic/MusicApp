package com.example.musicapp.model.artistPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artists {

    @SerializedName("artist")
    @Expose
    public List<Artist> artist = null;
    @SerializedName("@attr")
    @Expose
    public Attr attr;

}
