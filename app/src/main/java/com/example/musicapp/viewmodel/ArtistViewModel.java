package com.example.musicapp.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.musicapp.model.artistPojo.Artist;
import com.example.musicapp.repositories.ArtistDataRepository;

import java.util.List;

public class ArtistViewModel extends ViewModel {
    private ArtistDataRepository artistDataRepository;
    private MutableLiveData<List<Artist>> mutableLiveData;

    public ArtistViewModel() {
        artistDataRepository = new ArtistDataRepository();
    }

    public LiveData<List<Artist>> getArtistInfo() {
        if (mutableLiveData == null) {
            mutableLiveData = artistDataRepository.response();
        }

        return mutableLiveData;
    }
}