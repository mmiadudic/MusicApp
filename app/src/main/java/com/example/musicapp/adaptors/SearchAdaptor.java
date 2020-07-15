package com.example.musicapp.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.model.SearchItemData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchAdaptor extends RecyclerView.Adapter<SearchAdaptor.SearchViewHolder> {

    private ArrayList<SearchItemData> searchItemData;
    private OnArtistListener mOnArtistListener;


    public SearchAdaptor(ArrayList<SearchItemData> searchItemData, OnArtistListener onArtistListener) {
        this.searchItemData = searchItemData;
        mOnArtistListener = onArtistListener;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        SearchViewHolder holder = new SearchViewHolder(view, mOnArtistListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        Picasso.get().load(searchItemData.get(position).getImage()).into(holder.image);
        holder.name.setText(searchItemData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return searchItemData.size();
    }

    static class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        CircleImageView image;
        OnArtistListener onArtistListener;
        LinearLayout linearLayout;

        public SearchViewHolder(@NonNull View itemView, OnArtistListener onArtistListener) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.parent_layout3);
            name = itemView.findViewById(R.id.search_name);
            image = itemView.findViewById(R.id.icon_search);
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