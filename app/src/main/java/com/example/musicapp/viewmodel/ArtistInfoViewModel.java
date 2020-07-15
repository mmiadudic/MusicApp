package com.example.musicapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.musicapp.model.artistInfoPojo.ArtistInfoPojo;
import com.example.musicapp.repositories.ArtistInfoRepository;

public class ArtistInfoViewModel extends ViewModel {
    private MutableLiveData<ArtistInfoPojo> mutableLiveData;
    private ArtistInfoRepository artistInfoRepository;
    private String name;

    public ArtistInfoViewModel() {

    }

    public void init(String artistName) {
        this.name = artistName;
        artistInfoRepository = new ArtistInfoRepository(name);
    }

    public MutableLiveData<ArtistInfoPojo> getInfo() {
        if (mutableLiveData == null) {
            mutableLiveData = artistInfoRepository.getArtistBio();
        }

        return mutableLiveData;
    }
}
