package com.example.musicapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.musicapp.R;
import com.example.musicapp.viewmodel.ArtistInfoViewModel;

public class ArtistInfoFragment extends Fragment {
    private String artistName;
    TextView artistInfoName;
    TextView artistBio;


    public ArtistInfoFragment(String artistName) {
        this.artistName = artistName;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        container.removeAllViews();
        View view = inflater.inflate(R.layout.fragment_artist_info, container, false);

        artistInfoName = view.findViewById(R.id.artist_info_name);
        artistBio = view.findViewById(R.id.artist_info_bio);

        initInfoViewModel();
        return view;
    }

    private void initInfoViewModel() {
        ArtistInfoViewModel artistInfoViewModel;
        artistInfoViewModel = new ViewModelProvider(this).get(ArtistInfoViewModel.class);
        artistInfoViewModel.init(artistName);
        artistInfoViewModel.getInfo().observe(getViewLifecycleOwner(), responseInfo -> {
            if (responseInfo != null) {
                artistInfoName.setText(responseInfo.getArtistName());
                artistBio.setText(responseInfo.getArtistBio());
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
