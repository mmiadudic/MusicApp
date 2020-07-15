package com.example.musicapp.model.artistInfoPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("#text")
    @Expose
    public String text;
    @SerializedName("size")
    @Expose
    public String size;

}
