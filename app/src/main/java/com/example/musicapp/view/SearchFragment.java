package com.example.musicapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.adaptors.SearchAdaptor;
import com.example.musicapp.model.SearchItemData;
import com.example.musicapp.model.searchPojo.Artist;
import com.example.musicapp.model.searchPojo.Image;
import com.example.musicapp.viewmodel.SearchViewModel;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener, SearchAdaptor.OnArtistListener {

    RecyclerView recyclerView;
    SearchView searchView;
    SearchAdaptor searchAdaptor;
    ArrayList<SearchItemData> searchItemData = new ArrayList<>();
    String query;

    public SearchFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchView = view.findViewById(R.id.search_bar);
        recyclerView = view.findViewById(R.id.search_recycler);

        initSearch();

        initRecyclerView();

        return view;
    }

    private void initSearchViewModel() {

        SearchViewModel searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        searchViewModel.init(query);
        searchViewModel.getSearchResults().observe(getViewLifecycleOwner(), responseSearch -> {
            if (responseSearch != null) {
                List<Artist> artists = responseSearch;

                for (Artist artist : artists) {
                    String name = artist.name;
                    List<Image> images = artist.image;

                    searchItemData.add(new SearchItemData(name, images.get(2).text));
                }
            }
            searchAdaptor.notifyDataSetChanged();
        });
    }

    private void initRecyclerView() {
        if (searchAdaptor == null) {
            searchAdaptor = new SearchAdaptor(searchItemData, this);
            recyclerView.setAdapter(searchAdaptor);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        } else {
            searchAdaptor.notifyDataSetChanged();
        }
    }

    private void initSearch() {
        searchView.setOnQueryTextListener(this);
    }

    public void onResume() {
        super.onResume();
        //set title bar
        //((MainActivity) getActivity()).setActionBarTitle("Search");
        searchView.clearFocus();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        this.query = query;
        initSearchViewModel();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return false;
    }

    @Override
    public void onArtistClicked(int position) {
        ArtistInfoFragment myFragment = new ArtistInfoFragment(searchItemData.get(position).name);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                myFragment).commit();
    }
}
