package com.example.musicapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.musicapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    Button bt;
    TabLayout tabLayout;
    View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        TabItem tabArtist = findViewById(R.id.tabArtist);
        TabItem tabTrack = findViewById(R.id.tabTrack);
        SearchView searchView = findViewById(R.id.search_bar);
        Button bt = (Button) findViewById(R.id.button);
        layout = findViewById(R.id.info);


        final ViewPager viewPager = findViewById(R.id.viewPager);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        /*searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tabLayout.setVisibility(View.GONE);
                findViewById(R.id.viewPager).setVisibility(View.GONE);
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                tabLayout.setVisibility(View.VISIBLE);
                findViewById(R.id.viewPager).setVisibility(View.VISIBLE);
                return false;
            }
        });*/



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        bt.setOnClickListener(v -> {
            bt.setVisibility(GONE);
            tabLayout.setVisibility(View.GONE);
            findViewById(R.id.viewPager).setVisibility(View.GONE);

            FragmentManager fm = getSupportFragmentManager();
            SearchFragment searchFragment = new SearchFragment();
            fm.beginTransaction().replace(R.id.container, searchFragment).addToBackStack(null).commit();

        });
    }

    public void onBackPressedCallBack() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
            bt.setVisibility(View.VISIBLE);

            tabLayout.setVisibility(View.VISIBLE);
            findViewById(R.id.viewPager).setVisibility(View.VISIBLE);

        } else {
            super.onBackPressed();
        }
    }

}
