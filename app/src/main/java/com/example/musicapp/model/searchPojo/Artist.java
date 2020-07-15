package com.example.musicapp.model.searchPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artist {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("listeners")
    @Expose
    public String listeners;
    @SerializedName("mbid")
    @Expose
    public String mbid;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("streamable")
    @Expose
    public String streamable;
    @SerializedName("image")
    @Expose
    public List<Image> image = null;
}
