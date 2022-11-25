package com.example.app3.fragment.tabvpgfgmt.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app3.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;

public class BottomTabLayout {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Context mContext;
    private  List<String> mTitles = new ArrayList<>();
    //底部Tab标题
    //返回CustomBotTabItem实例
    public static BottomTabLayout create() {
        return TabItemHolder.mBottomTabLayout;
    }

    //引入布局需要的Context
    public BottomTabLayout setContext(Context context, List<String> titles) {
        mContext = context;
        mTitles=titles;
        return this;
    }
    //需要自定义的TabLayout
    public BottomTabLayout setTabLayout(TabLayout tabLayout) {
        mTabLayout = tabLayout;
        return this;
    }
    //设置与TabLayout关联的ViewPager
    public BottomTabLayout setViewPager(ViewPager viewPager) {
        mViewPager = viewPager;
        return this;
    }
    //创建Tab
    public BottomTabLayout build() {
        initTabLayout();
        return this;
    }
    //初始化Tab
    private void initTabLayout() {
        mTabLayout.setupWithViewPager(mViewPager);
        //第二个参数为selector，下同
        mTabLayout.getTabAt(0).setCustomView(getTabView(0, R.drawable.home_button_selector));

        mTabLayout.getTabAt(1).setCustomView(getTabView(1, R.drawable.home_button_selector));
        mTabLayout.getTabAt(2).setCustomView(getTabView(2, R.drawable.home_button_selector));
        mTabLayout.getTabAt(3).setCustomView(getTabView(3, R.drawable.home_button_selector));
//        mTabLayout.getTabAt(4).setCustomView(getTabView(4, R.mipmap.index));
        tabSelectListener();
    }
    //自定义Tab样式
    private View getTabView(final int position, int resId) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.bottom_tab_layout, null);
        TextView tvTitle = (TextView) view.findViewById(R.id.tab_content_text);
        final ImageView ivTitle = (ImageView) view.findViewById(R.id.tab_content_image);
        ivTitle.setImageResource(resId);
        tvTitle.setText(mTitles.get(position));
        //默认第一个tab选中，设置字体为选中色
        if (position == 0) {
            tvTitle.setTextColor(Color.parseColor("#4192e3"));
        } else {
            tvTitle.setTextColor(Color.parseColor("#262a3b"));
        }
        //点击Tab切换
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(position);
            }
        });
        return view;
    }
    //Tab监听
    private void tabSelectListener() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changeTabStatus(tab, true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                changeTabStatus(tab, false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    //切换Tab文字是否选中的的颜色
    private void changeTabStatus(TabLayout.Tab tab, boolean selected) {
        View view = tab.getCustomView();
        int current=tab.getPosition();
        if (view == null) {
            return;
        }
        TextView tvTitle = (TextView) view.findViewById(R.id.tab_content_text);
        if (selected) {
            tvTitle.setTextColor(Color.parseColor("#4192e3"));
        } else {
            tvTitle.setTextColor(Color.parseColor("#262a3b"));
        }
        switch (current){
            case 0:
                break;
        }
    }

    //创建CustomBotTabItem实例
    private static class TabItemHolder {
        private static BottomTabLayout mBottomTabLayout = new BottomTabLayout();
    }
}
