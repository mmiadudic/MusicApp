package com.example.musicapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.adaptors.ArtistAdaptor;
import com.example.musicapp.model.ArtistItemData;
import com.example.musicapp.model.artistPojo.Artist;
import com.example.musicapp.model.artistPojo.Image;
import com.example.musicapp.viewmodel.ArtistViewModel;

import java.util.ArrayList;
import java.util.List;

public class ArtistFragment extends Fragment{
    private ArtistAdaptor artistAdaptor;
    private RecyclerView artistRecyclerView;

    private ArrayList<ArtistItemData> artistItemData = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_artist, container, false);

        artistRecyclerView = view.findViewById(R.id.recycler_artist);

        initArtistViewModel();
        initArtistRecyclerView();
        return view;

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

    }

    private void initArtistRecyclerView() {
        if (artistAdaptor == null) {
            artistAdaptor = new ArtistAdaptor(artistItemData, this.getContext());
            artistRecyclerView.setAdapter(artistAdaptor);
            artistRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        } else {
            artistAdaptor.notifyDataSetChanged();
        }
    }

    private void initArtistViewModel() {


        ArtistViewModel artistViewModel = new ViewModelProvider(this).get(ArtistViewModel.class);

        artistViewModel.getArtistInfo().observe(getViewLifecycleOwner(), new Observer<List<Artist>>() {
            @Override
            public void onChanged(List<Artist> responseArtist) {

                if (responseArtist != null) {
                    List<Artist> artists = responseArtist;

                    if (artists != null) {

                        for (Artist att : artists) {
                            String name = att.name;
                            String listeners = att.listeners;
                            String playcount = att.playcount;
                            List<Image> images = att.image;


                            artistItemData.add(new ArtistItemData(name, listeners, playcount, images.get(2).text));
                        }

                    }
                }
                artistAdaptor.notifyDataSetChanged();
            }
        });

    }


    public void onResume() {
        super.onResume();
        //set title bar
        ((MainActivity) getActivity()).setActionBarTitle("Top Artist");
    }


}