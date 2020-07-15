package com.example.musicapp.model.searchPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResponse {


    @SerializedName("results")
    @Expose
    public Results results;
}
