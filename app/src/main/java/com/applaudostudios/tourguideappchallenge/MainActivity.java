package com.applaudostudios.tourguideappchallenge;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.applaudostudios.tourguideappchallenge.adapters.FragmentPagerAdapter;
import com.applaudostudios.tourguideappchallenge.fragments.BeachesFragment;
import com.applaudostudios.tourguideappchallenge.fragments.HikingFragment;
import com.applaudostudios.tourguideappchallenge.fragments.LakesAndWaterFallsFragment;
import com.applaudostudios.tourguideappchallenge.fragments.TownsAndArchaeologicalPlacesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.viewpager);
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());

        // Adds each fragment into the adapter and assigns the name of the tabs
        adapter.AddFragment(new BeachesFragment(), "Beaches");
        adapter.AddFragment(new HikingFragment(), "Hiking Places");
        adapter.AddFragment(new TownsAndArchaeologicalPlacesFragment(), "Cultural Places");
        adapter.AddFragment(new LakesAndWaterFallsFragment(), "Lakes and Waterfalls");

        //Sets the adapter to the ViewPager
        viewPager.setAdapter(adapter);

        // Attaches the TabLayout to the ViewPager
        tabLayout.setupWithViewPager(viewPager);

        // Remove shadow from the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
        }

    }

}
