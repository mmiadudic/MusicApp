package com.example.musicapp.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.musicapp.model.Api;
import com.example.musicapp.model.artistPojo.Artist;
import com.example.musicapp.model.artistPojo.ArtistResponse;
import com.example.musicapp.model.artistPojo.Artists;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArtistDataRepository {
    private static final String API_KEY = "bd7f9229d3033b3491d7d5047bd5a93e";
    private static final String METHOD = "chart.gettopartists";
    private static final String FORMAT = "json";
    private static final String BASE_URL = "https://ws.audioscrobbler.com";

    //https://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=bd7f9229d3033b3491d7d5047bd5a93e&format=json

    private Api api;

    public ArtistDataRepository() {
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public MutableLiveData<List<Artist>> response() {
        final MutableLiveData<List<Artist>> artistResponseMutableLiveData = new MutableLiveData<>();

        Call<ArtistResponse> callArtists = api.getArtists(METHOD, API_KEY, FORMAT);
        callArtists.enqueue(new Callback<ArtistResponse>() {
            @Override
            public void onResponse(Call<ArtistResponse> call, Response<ArtistResponse> response) {

                if (response.isSuccessful()) {

                    ArtistResponse artistResponse = response.body();

                    Artists artists = artistResponse.artists;

                    List<Artist> artistList = artists.artist;
                    if (artistResponse != null) {

                        artistResponseMutableLiveData.setValue(artistList);
                    }

                }

            }

            @Override
            public void onFailure(Call<ArtistResponse> call, Throwable t) {
                Log.d("Response", "usao sam u response" + t.getMessage() + call.isExecuted());
            }

        });

        return artistResponseMutableLiveData;
    }
}
