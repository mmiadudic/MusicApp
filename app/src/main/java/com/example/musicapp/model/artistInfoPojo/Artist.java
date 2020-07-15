package com.example.musicapp.model.artistInfoPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artist {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("mbid")
    @Expose
    public String mbid;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("image")
    @Expose
    public List<Image> image = null;
    @SerializedName("streamable")
    @Expose
    public String streamable;
    @SerializedName("ontour")
    @Expose
    public String ontour;
    @SerializedName("stats")
    @Expose
    public Stats stats;
    @SerializedName("similar")
    @Expose
    public Similar similar;
    @SerializedName("tags")
    @Expose
    public Tags tags;
    @SerializedName("bio")
    @Expose
    public Bio bio;

}
