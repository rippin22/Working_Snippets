package com.example.matthew.tmro;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return DrawStorageController.newInstance();
            case 1:
                return DrawController.newInstance();
            default:
                return null;
        }}
            @Override
            public int getCount () {
                return 2;//NUM_PAGES;
            }
}