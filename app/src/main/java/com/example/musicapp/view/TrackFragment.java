package com.example.musicapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.adaptors.TrackAdaptor;
import com.example.musicapp.model.TrackItemData;
import com.example.musicapp.model.trackPojo.Image;
import com.example.musicapp.model.trackPojo.Track;
import com.example.musicapp.viewmodel.TrackViewModel;

import java.util.ArrayList;
import java.util.List;

public class TrackFragment extends Fragment {
    private TrackAdaptor trackAdaptor;
    private RecyclerView trackRecyclerView;

    private ArrayList<TrackItemData> trackItemData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tracks, container, false);

        trackRecyclerView = view.findViewById(R.id.recycler_track);

        initTrackViewModel();
        initTrackRecyclerView();
        return view;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    private void initTrackRecyclerView() {
        if (trackAdaptor == null) {
            trackAdaptor = new TrackAdaptor(trackItemData, this.getContext());
            trackRecyclerView.setAdapter(trackAdaptor);
            trackRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        } else {
            trackAdaptor.notifyDataSetChanged();
        }
    }

    private void initTrackViewModel() {

        TrackViewModel trackViewModel = new ViewModelProvider(this).get(TrackViewModel.class);
        trackViewModel.getTrackInfo().observe(getViewLifecycleOwner(), responseTrack -> {

            if (responseTrack != null) {
                List<Track> tracks = responseTrack;

                if (tracks != null) {

                    for (Track t : tracks) {
                        String name = t.name;
                        String listeners = t.listeners;
                        String playcount = t.playcount;
                        List<Image> images = t.image;
                        String artistName = t.getArtist().getName();

                        trackItemData.add(new TrackItemData(name, listeners, playcount, images.get(2).text, artistName));
                    }
                }
            }
            trackAdaptor.notifyDataSetChanged();
        });

    }
}