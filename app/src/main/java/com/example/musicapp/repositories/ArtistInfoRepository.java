package com.example.musicapp.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.musicapp.model.Api;
import com.example.musicapp.model.artistInfoPojo.ArtistInfoPojo;
import com.example.musicapp.model.artistInfoPojo.ArtistInfoResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArtistInfoRepository {
    private static final String API_KEY = "bd7f9229d3033b3491d7d5047bd5a93e";
    private static final String METHOD = "artist.getinfo";
    private static final String FORMAT = "json";
    private static final String BASE_URL = "https://ws.audioscrobbler.com";

    private String artistName;
    private MutableLiveData<ArtistInfoPojo> mutableLiveData = new MutableLiveData<>();
    private Api api;

    public ArtistInfoRepository(String artistName) {
        this.artistName = artistName;
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public MutableLiveData<ArtistInfoPojo> getArtistBio() {
        Call<ArtistInfoResponse> searchResults = api.getInfoResults(METHOD, artistName, API_KEY, FORMAT);

        searchResults.enqueue(new Callback<ArtistInfoResponse>() {
            @Override
            public void onResponse(Call<ArtistInfoResponse> call, Response<ArtistInfoResponse> response) {
                if (response.isSuccessful()) {
                    ArtistInfoResponse artistInfoResponse = response.body();
                    String bio = artistInfoResponse.artist.bio.summary;
                    ArtistInfoPojo artistInfoPojo = new ArtistInfoPojo(artistName, bio);

                    mutableLiveData.setValue(artistInfoPojo);
                }
            }

            @Override
            public void onFailure(Call<ArtistInfoResponse> call, Throwable t) {
            }
        });

        return mutableLiveData;
    }
}
