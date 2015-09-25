package com.icaboalo.toolbarexampledevfbatch6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edgar Salvador Maurilio on 24/09/2015.
 */
public class Fragment1 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.myTabLayout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.myViewPager);

        MyAdapterViewPager myAdapterViewPager =
                new MyAdapterViewPager(getChildFragmentManager(), createPagers());

        viewPager.setAdapter(myAdapterViewPager);
        tabLayout.setupWithViewPager(viewPager);

    }

    private List<ModelFramentPager> createPagers() {

        List<ModelFramentPager> modelFramentPagers = new ArrayList<>();

        modelFramentPagers.add(new ModelFramentPager(new Fragment2(), "Tab 1"));
        modelFramentPagers.add(new ModelFramentPager(new Fragment3(), "Tab 2"));

        return modelFramentPagers;
    }
}
