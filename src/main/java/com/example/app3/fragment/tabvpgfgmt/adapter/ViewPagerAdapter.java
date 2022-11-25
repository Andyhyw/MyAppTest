package com.example.app3.fragment.tabvpgfgmt.adapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragmentList = new LinkedList<>();
    private FragmentManager fm;
    List<String> mTablist = new ArrayList<String>();

    public ViewPagerAdapter(FragmentManager fm,List<Fragment> mList,List<String> tablist) {
        super(fm);
        this.fm = fm;
        this.fragmentList = mList;
        this.mTablist=tablist;

    }
    public ViewPagerAdapter(FragmentManager fm,List<Fragment> mList) {
        super(fm);
        this.fm = fm;
        this.fragmentList = mList;

    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTablist.get(position);
    }
}


