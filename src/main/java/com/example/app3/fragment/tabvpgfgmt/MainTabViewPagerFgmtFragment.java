package com.example.app3.fragment.tabvpgfgmt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app3.R;
import com.example.app3.fragment.dongtai.MeFragment;
import com.example.app3.fragment.tabvpgfgmt.adapter.ViewPagerAdapter;
import com.example.app3.fragment.tabvpgfgmt.fragment.HotFragment;
import com.example.app3.event.MainFgmtEvent;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

public class MainTabViewPagerFgmtFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    String[] mTitles = {"新闻","学习","购物","科技","电影","音乐","综艺"};
    List<String> tablist = new ArrayList<String>();

    View view;

    static MainTabViewPagerFgmtFragment mainTabViewPagerFgmtFragment;
    public static MainTabViewPagerFgmtFragment getInstance(){
        if (mainTabViewPagerFgmtFragment ==null){
            mainTabViewPagerFgmtFragment = new MainTabViewPagerFgmtFragment();
        }
        return mainTabViewPagerFgmtFragment;
    }

    @Subscribe
    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_main_tab_view_pager_fgmt,container,false);

        mViewPager = view.findViewById(R.id.view_pager);
        mTabLayout = view.findViewById(R.id.tabLay);

        List<Fragment> fragments = new ArrayList<>();//存放Fragment的容器
        fragments.add(new HotFragment());//热门
        fragments.add(new HotFragment());//直播
        fragments.add(new HotFragment());//推荐
        fragments.add(new HotFragment());//最新
        fragments.add(new MeFragment());//直播
        fragments.add(new HotFragment());//推荐
        fragments.add(new HotFragment());//最新

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        //设置标题方式一
        //mTabLayout.getTabAt(0).setText("热门");
        //mTabLayout.getTabAt(1).setText("直播");
        //mTabLayout.getTabAt(2).setText("推荐");
        //mTabLayout.getTabAt(3).setText("最新");
        //ViewPagerAdapter adapterFragment = new ViewPagerAdapter(fragmentManager,fragments);

        //设置标题方式二
        for (String mTitle : mTitles) {
            // mTabLayout.addTab(mTabLayout.newTab().setText(mTitle));
            tablist.add(mTitle);
        }

        ViewPagerAdapter adapterFragment = new ViewPagerAdapter(fragmentManager,fragments,tablist);
        mViewPager.setAdapter(adapterFragment);


        //设置tab实现方式一（顶部、底部改变布局）
        mTabLayout.setupWithViewPager(mViewPager);//tab  viewpager关联
        mTabLayout.setTabIndicatorFullWidth(true);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        //设置tab 方式二 自定义底部布局
        //BottomTabLayout item = BottomTabLayout.create();
        //item.setContext(this,tablist)
        // .setViewPager(mViewPager)
        // .setTabLayout(mTabLayout)
        // .build();

        return view;
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void  getStateEvent(MainFgmtEvent eventInter){
        onRefreshUi(eventInter);
    }

    private void onRefreshUi(MainFgmtEvent eventInter) {
        Toast.makeText(getContext(),eventInter.getMsg(),Toast.LENGTH_SHORT).show();

    }
}