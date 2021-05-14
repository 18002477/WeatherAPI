package com.cedric.simpleweatherapp.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cedric.simpleweatherapp.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public SectionsPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
       switch (position)
       {
           case 0:
               return new CurrentFragment();
           case 1:
               return new WeeklyFragment();
           case 2:
               return new SearchFragment();
           default:
               return null;
       }
    }


    @Override
    public int getCount() {
        // Show 3 total pages.
        return numOfTabs;
    }
}