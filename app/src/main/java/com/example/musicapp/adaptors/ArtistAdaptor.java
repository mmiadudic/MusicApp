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
import com.example.musicapp.model.ArtistItemData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArtistAdaptor extends RecyclerView.Adapter<ArtistAdaptor.ArtistViewHolder> {
    ArrayList<ArtistItemData> artists;
    Context context;

    public ArtistAdaptor(ArrayList<ArtistItemData> artists, Context context) {
        this.artists = artists;
        this.context = context;
    }

    @NonNull
    @Override
    public ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_artist, parent, false);
        ArtistViewHolder holder = new ArtistViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistViewHolder holder, int position) {

        Picasso.get().load(artists.get(position).getImage()).into(holder.image);
        holder.name.setText(artists.get(position).getName());
        holder.listeners.setText("Listeners: " + artists.get(position).getListeners());
        holder.playcount.setText("Playcount: " +artists.get(position).getPlaycount());
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    static class ArtistViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView name;
        TextView playcount;
        TextView listeners;
        LinearLayout linearLayout;
        public ArtistViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.parent_layout);
            image = itemView.findViewById(R.id.artist_icon);
            name = itemView.findViewById(R.id.artist_name);
            playcount = itemView.findViewById(R.id.artist_count);
            listeners = itemView.findViewById(R.id.artist_listenrs);
        }
    }
}