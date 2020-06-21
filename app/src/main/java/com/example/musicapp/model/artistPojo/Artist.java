package com.example.musicapp.model.artistPojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artist {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("playcount")
    @Expose
    public String playcount;
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