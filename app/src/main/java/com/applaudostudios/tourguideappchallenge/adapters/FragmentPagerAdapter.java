package com.applaudostudios.tourguideappchallenge.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> titlesList = new ArrayList<>();

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // Returns a fragment associated wih each position
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    // Returns the number of pages in the ViewPager
    @Override
    public int getCount() {
        return titlesList.size();
    }

    // Returns a string describing each page
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlesList.get(position);
    }

    // Method used in the MainActivity
    public void AddFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titlesList.add(title);
    }

}
