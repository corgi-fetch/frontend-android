package com.corgo.corgoandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Daniel on 12/30/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumTabs = NumOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new TimelineFragment();
            case 1: return new GroupFragment();
            //case 2: return new JobFragment();
            case 2: return new PostFragment();
            case 3: return new NotificationFragment();
            case 4: return new MenuFragment();
            default: return null;
        }

    }

    @Override
    public int getCount() {
        return mNumTabs;
    }
}
