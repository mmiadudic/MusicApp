package com.example.musicapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.musicapp.model.trackPojo.Track;
import com.example.musicapp.repositories.TrackDataRepository;

import java.util.List;

public class TrackViewModel extends ViewModel {
    private TrackDataRepository trackDataRepository;
    private MutableLiveData<List<Track>> mutableLiveData;

    public TrackViewModel() {trackDataRepository = new TrackDataRepository();}

    public LiveData<List<Track>> getTrackInfo() {
        if (mutableLiveData == null) {
            mutableLiveData = trackDataRepository.response();
        }
        return mutableLiveData;
    }

}
