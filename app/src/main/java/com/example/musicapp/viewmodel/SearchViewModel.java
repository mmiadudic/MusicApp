package com.example.musicapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.musicapp.model.searchPojo.Artist;
import com.example.musicapp.repositories.SearchRepository;

import java.util.List;

public class SearchViewModel extends ViewModel {

    SearchRepository searchRepository;
    MutableLiveData<List<Artist>> mutableLiveData;
    String query;

    public SearchViewModel() {
    }

    public void init(String query) {
        this.query = query;
        searchRepository = new SearchRepository(query);
    }

    public MutableLiveData<List<Artist>> getSearchResults() {
        if (mutableLiveData == null) {
            mutableLiveData = searchRepository.getResults();
        }

        return mutableLiveData;
    }
}
