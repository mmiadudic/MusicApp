package com.example.musicapp.model.artistPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attr {

    @SerializedName("page")
    @Expose
    public String page;
    @SerializedName("perPage")
    @Expose
    public String perPage;
    @SerializedName("totalPages")
    @Expose
    public String totalPages;
    @SerializedName("total")
    @Expose
    public String total;

}