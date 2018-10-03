package com.example.neelansh.fragmenttest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;

public class pager extends FragmentPagerAdapter {
private List<Fragment> fragments;
    public pager(FragmentManager fm) {
        super(fm);
   fragments =new ArrayList<>();
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);

    }

    @Override
    public int getCount() {
        return fragments.size();
    }
public void addfragment(Fragment f){
        fragments.add(f);
}

}
