package com.example.musicapp.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.musicapp.model.Api;
import com.example.musicapp.model.trackPojo.Track;
import com.example.musicapp.model.trackPojo.TrackResponse;
import com.example.musicapp.model.trackPojo.Tracks;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrackDataRepository {

    private static final String API_KEY = "bd7f9229d3033b3491d7d5047bd5a93e";
    private static final String METHOD = "chart.gettoptracks";
    private static final String FORMAT = "json";
    private static final String BASE_URL = "https://ws.audioscrobbler.com";

    //https://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=bd7f9229d3033b3491d7d5047bd5a93e&format=json

    private Api api;

    public TrackDataRepository() { initRetrofit();}

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public MutableLiveData<List<Track>> response() {
        MutableLiveData<List<Track>> trackResponseMutableLiveData = new MutableLiveData<>();

        Call<TrackResponse> callTrack = api.getTrack(METHOD, API_KEY, FORMAT);
        callTrack.enqueue(new Callback<TrackResponse>() {
            @Override
            public void onResponse(Call<TrackResponse> call, Response<TrackResponse> response) {
                if (response.isSuccessful()) {
                    TrackResponse trackResponse = response.body();
                    Tracks tracks = trackResponse.tracks;
                    List<Track> trackList = tracks.track;
                    if(trackResponse != null) {
                        trackResponseMutableLiveData.setValue(trackList);
                    }
                }
            }

            @Override
            public void onFailure(Call<TrackResponse> call, Throwable t) {
            }
        });
        return trackResponseMutableLiveData;
    }
}