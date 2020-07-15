package com.example.musicapp.model.searchPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("opensearch:Query")
    @Expose
    public OpenSearchQuery opensearchQuery;
    @SerializedName("opensearch:totalResults")
    @Expose
    public String opensearchTotalResults;
    @SerializedName("opensearch:startIndex")
    @Expose
    public String opensearchStartIndex;
    @SerializedName("opensearch:itemsPerPage")
    @Expose
    public String opensearchItemsPerPage;
    @SerializedName("artistmatches")
    @Expose
    public ArtistMatches artistmatches;
    @SerializedName("@attr")
    @Expose
    public Attr attr;
}
