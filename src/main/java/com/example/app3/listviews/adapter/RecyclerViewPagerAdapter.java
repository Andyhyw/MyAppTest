package com.example.app3.listviews.adapter;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class RecyclerViewPagerAdapter extends androidx.viewpager.widget.PagerAdapter {

    List<String> stringList;

    public RecyclerViewPagerAdapter(List<String> stringList) {
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ViewPager.LayoutParams params = new ViewPager.LayoutParams();
        params.width = ViewPager.LayoutParams.WRAP_CONTENT;
        params.height = ViewPager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER;
        TextView textView = new TextView(container.getContext());
        textView.setText(stringList.get(position));
        textView.setTextSize(30);
        textView.setTextColor(Color.parseColor("#333333"));
        textView.setLayoutParams(params);
        container.addView(textView);
        return textView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}