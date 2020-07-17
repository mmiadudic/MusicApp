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
    private OnArtistListener mOnArtistListener;

    public ArtistAdaptor(ArrayList<ArtistItemData> artists, Context context, OnArtistListener onArtistListener) {
        this.artists = artists;
        this.context = context;
        mOnArtistListener = onArtistListener;
    }

    @NonNull
    @Override
    public ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_artist, parent, false);
        ArtistViewHolder holder = new ArtistViewHolder(view, mOnArtistListener);
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

    static class ArtistViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView image;
        TextView name;
        TextView playcount;
        TextView listeners;
        LinearLayout linearLayout;
        OnArtistListener onArtistListener;

        public ArtistViewHolder(@NonNull View itemView, OnArtistListener onArtistListener) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.parent_layout);
            image = itemView.findViewById(R.id.artist_icon);
            name = itemView.findViewById(R.id.artist_name);
            playcount = itemView.findViewById(R.id.artist_count);
            listeners = itemView.findViewById(R.id.artist_listenrs);

            this.onArtistListener = onArtistListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onArtistListener.onArtistClicked(getAdapterPosition());
        }
    }

    //interface for listener
    public interface OnArtistListener {
        void onArtistClicked(int position);
    }
}