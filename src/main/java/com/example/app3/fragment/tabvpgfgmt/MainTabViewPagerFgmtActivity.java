package com.example.app3.fragment.tabvpgfgmt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.event.MainActEvent;
import com.example.app3.event.MainFgmtEvent;
import com.example.app3.fragment.tabvpgfgmt.adapter.ViewPagerAdapter;
import com.example.app3.fragment.tabvpgfgmt.fragment.HotFragment;
import com.example.app3.fragment.tabvpgfgmt.utils.BottomTabLayout;
import com.example.app3.model.User;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainTabViewPagerFgmtActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    String[] mTitles = {"热门","直播","推荐","最新"};
    List<String> tablist = new ArrayList<String>();
    TextView textView;

    @Subscribe//annotation
    @Override
    public void onCreate(Bundle savedInstanceState) {//EventBus注册   一定在public方法里面
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab_view_pager_fgmt);

        EventBus.getDefault().register(this);//接收方---注册EventBus

        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tabLay);

        textView=findViewById(R.id.tv_title_act);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MainFgmtEvent("activity传参"));
            }
        });

        List<Fragment> fragments = new ArrayList<>();//存放Fragment的容器
        fragments.add(new MainTabViewPagerFgmtFragment());//热门
        fragments.add(new HotFragment());//直播
        fragments.add(new HotFragment());//推荐
        fragments.add(new HotFragment());//最新

        FragmentManager fragmentManager = getSupportFragmentManager();
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
//        mTabLayout.setupWithViewPager(mViewPager);//tab  viewpager关联

        //设置tab 方式二 自定义底部布局
        BottomTabLayout item = BottomTabLayout.create();
        item.setContext(this,tablist)
                .setViewPager(mViewPager)
                .setTabLayout(mTabLayout)
                .build();
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }



    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);//接收方--注销EventBus
        super.onDestroy();

    }

    //接收方
    @Subscribe(threadMode = ThreadMode.MAIN) //接收方---订阅事件（接受返回）
    public void getMainfgmtMsg(MainActEvent mainActEvent){
            User user = mainActEvent.getUser();
        onRefresh(user);
    }

    private void onRefresh(User user) {
        textView.setText(user.getName());
    }
}