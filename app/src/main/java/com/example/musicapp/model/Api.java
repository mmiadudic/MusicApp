package com.example.musicapp.model;


import com.example.musicapp.model.artistPojo.ArtistResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    //http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=bd7f9229d3033b3491d7d5047bd5a93e&format=json
    @GET("/2.0/?")
    Call<ArtistResponse> getArtists(@Query("method") String method,
                                    @Query("api_key") String api_key,
                                    @Query("format") String json);
}