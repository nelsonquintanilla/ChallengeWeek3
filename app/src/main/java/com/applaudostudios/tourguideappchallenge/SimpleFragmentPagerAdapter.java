package com.applaudostudios.tourguideappchallenge;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {


    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ParksFragment();
            case 1:
                return new BeachesFragment();
            case 2:
                return new HikingFragment();
            case 3:
                return new MuseumsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Park";
            case 1:
                return "Beach";
            case 2:
                return "Hiking";
            case 3:
                return "Museum";
            default:
                return null;
        }
    }
}
