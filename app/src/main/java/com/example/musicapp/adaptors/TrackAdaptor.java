package com.example.musicapp.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.model.TrackItemData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TrackAdaptor extends RecyclerView.Adapter<TrackAdaptor.TrackViewHolder> {

    ArrayList<TrackItemData> tracks;
    Context context;

    public TrackAdaptor(ArrayList<TrackItemData> tracks, Context context) {
        this.tracks = tracks;
        this.context = context;
    }

    @NonNull
    @Override
    public TrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_track, parent, false);
        TrackViewHolder holder = new TrackViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TrackViewHolder holder, int position) {
        Picasso.get().load(tracks.get(position).getImage()).into(holder.image);
        holder.name.setText(tracks.get(position).getName());
        holder.listeners.setText("Listeners: " + tracks.get(position).getListeners());
        holder.playcount.setText("Playcount: " + tracks.get(position).getPlaycount());
        holder.artistName.setText(tracks.get(position).getArtistName());
    }
    @Override
    public int getItemCount() {
        return tracks.size();
    }

    static class TrackViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView name;
        TextView playcount;
        TextView listeners;
        TextView artistName;

        LinearLayout linearLayout;

        public TrackViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.parent_layout2);
            image = itemView.findViewById(R.id.track_icon);
            name = itemView.findViewById(R.id.track_name);
            playcount = itemView.findViewById(R.id.track_playcount);
            listeners = itemView.findViewById(R.id.track_listeners);
            artistName = itemView.findViewById(R.id.track_artist);
        }
    }
}

