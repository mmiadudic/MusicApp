package com.example.musicapp.model.searchPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpenSearchQuery {
    @SerializedName("#text")
    @Expose
    public String text;
    @SerializedName("role")
    @Expose
    public String role;
    @SerializedName("searchTerms")
    @Expose
    public String searchTerms;
    @SerializedName("startPage")
    @Expose
    public String startPage;

}
