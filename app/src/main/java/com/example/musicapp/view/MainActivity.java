package com.example.musicapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.musicapp.R;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {
    Button bt1, bt2, bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.button1);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt1.setVisibility(GONE);
                bt2.setVisibility(GONE);
                bt3.setVisibility(GONE);

                FragmentManager fm = getSupportFragmentManager();
                ArtistFragment artistFragment = new ArtistFragment();
                fm.beginTransaction().replace(R.id.container, artistFragment).addToBackStack(null).commit();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt1.setVisibility(GONE);
                bt2.setVisibility(GONE);
                bt3.setVisibility(GONE);
                FragmentManager fm = getSupportFragmentManager();
                TracksFragment tracksFragment = new TracksFragment();
                fm.beginTransaction().replace(R.id.container, tracksFragment).addToBackStack(null).commit();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt1.setVisibility(GONE);
                bt2.setVisibility(GONE);
                bt3.setVisibility(GONE);
                FragmentManager fm = getSupportFragmentManager();
                SearchFragment searchFragment = new SearchFragment();
                fm.beginTransaction().replace(R.id.container, searchFragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
            bt1.setVisibility(View.VISIBLE);
            bt2.setVisibility(View.VISIBLE);
            bt3.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();

        }
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


}