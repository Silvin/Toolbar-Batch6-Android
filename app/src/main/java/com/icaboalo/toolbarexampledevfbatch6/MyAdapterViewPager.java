package com.icaboalo.toolbarexampledevfbatch6;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Edgar Salvador Maurilio on 24/09/2015.
 */
public class MyAdapterViewPager extends FragmentPagerAdapter {

    private List<ModelFramentPager> pagerList;

    public MyAdapterViewPager(FragmentManager fm, List<ModelFramentPager> pagerList) {
        super(fm);
        this.pagerList = pagerList;
    }

    @Override
    public Fragment getItem(int position) {
        return pagerList.get(position).getPager();
    }

    @Override
    public int getCount() {
        return pagerList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pagerList.get(position).getTitle();
    }

}
