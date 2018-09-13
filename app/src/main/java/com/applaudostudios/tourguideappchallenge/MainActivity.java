package com.applaudostudios.tourguideappchallenge;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewpager);
        adapter = new FragmentPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new BeachesFragment(), "Beaches");
        adapter.AddFragment(new HikingFragment(), "Hiking Places");
        adapter.AddFragment(new TownsAndArchaeologicalPlacesFragment(), "Cultural Places");
        adapter.AddFragment(new LakesAndWaterFallsFragment(), "Lakes and Waterfalls");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        // Remove shadow from the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

    }

}
