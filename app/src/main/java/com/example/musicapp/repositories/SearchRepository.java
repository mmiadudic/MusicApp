package com.example.musicapp.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.musicapp.model.Api;
import com.example.musicapp.model.searchPojo.Artist;
import com.example.musicapp.model.searchPojo.ArtistMatches;
import com.example.musicapp.model.searchPojo.SearchResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchRepository {
    private static final String API_KEY = "bd7f9229d3033b3491d7d5047bd5a93e";
    private static final String METHOD = "artist.search";
    private static final String FORMAT = "json";
    private static final String BASE_URL = "https://ws.audioscrobbler.com";

    private String query;
    private MutableLiveData<List<Artist>> mutableLiveData = new MutableLiveData<>();
    private Api api;

    public SearchRepository(String query) {
        this.query = query;
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public MutableLiveData<List<Artist>> getResults() {
        Call<SearchResponse> searchResults = api.getSearchResults(METHOD, query, API_KEY, FORMAT);

        searchResults.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.isSuccessful()) {

                    SearchResponse searchResponse = response.body();
                    ArtistMatches artistmatches = searchResponse.results.artistmatches;

                    mutableLiveData.setValue(artistmatches.artist);
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
