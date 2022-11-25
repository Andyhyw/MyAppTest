package com.example.app3.fragment.viewpagerfgmt;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.fragment.tabvpgfgmt.MainTabViewPagerFgmtFragment;
import com.example.app3.fragment.viewpagerfgmt.adapter.MyFragmentPagerAdapter;
import com.example.app3.fragment.viewpagerfgmt.fragment.BlankFragment;
import com.example.app3.fragment.viewpagerfgmt.fragment.MyFragmnet;
import java.util.LinkedList;
import java.util.List;

import javax.microedition.khronos.egl.EGLDisplay;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

/**
 * fragment+viewpager
 */

public class MainViewPagerFgmtActivity extends FragmentActivity  implements View.OnClickListener {
    private static final String TAG = "MainViewPagerFgmtActivi";
    ViewPager2 viewPager;
    Button[]  buttons = new Button[5];
    int current = 0;


    
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpgfgmt);

        buttons[0] = findViewById(R.id.index);
        buttons[0].setOnClickListener(this);
        buttons[1]= findViewById(R.id.info);
        buttons[1].setOnClickListener(this);

        buttons[2] = findViewById(R.id.note);
        buttons[2].setOnClickListener(this);
        buttons[3] = findViewById(R.id.mine);
        buttons[3].setOnClickListener(this);

        buttons[4] = findViewById(R.id.hot);
        buttons[4].setOnClickListener(this);
        initViewPager();

//        EditText editText =null;
//        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                return false;
//            }
//        });
//        editText.setFocusable();
//        editText.isFocused()
//        editText.setEnabled(false);
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Log.d(TAG,"beforeTextChanged");
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d(TAG,"beforeTextChanged");
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                Log.d(TAG,"beforeTextChanged");
//            }
//        });
//
//        editText.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                return false;
//            }
//        });
//        editText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        //View  ---控件
        //ViewGroup ---布局  layout

    }

    private void initViewPager() {
        viewPager = findViewById(R.id.view_pager);
        List<Fragment> fragmentList = new LinkedList<>();
        fragmentList.add(BlankFragment.newInstance("home"));
        fragmentList.add(BlankFragment.newInstance("info"));
        fragmentList.add(BlankFragment.newInstance("note"));

        fragmentList.add(MyFragmnet.getInstance());//这个由于与其它三个Fragment布局结构不一样所以需要新建一个Fragment类进行初始化

        fragmentList.add(MainTabViewPagerFgmtFragment.getInstance());

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragmentList);
        viewPager.setAdapter(myFragmentPagerAdapter);//数据源

        //监听Fragment的界面变化
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                //其中position为当前Fragment的索引
                changePager(position);//绑定 button
                Log.d(TAG,"onPageScrolled");
            }
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });



//        viewPager.setCurrentItem();
//        viewPager.addItemDecoration();
//        viewPager.

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.index:
                changebgColor(0);
                break;
            case R.id.info:
                changebgColor(1);
                break;
            case R.id.note:
                changebgColor(2);
                break;
            case R.id.mine:
                changebgColor(3);
                break;
            case R.id.hot:
                changebgColor(4);
                break;
        }
    }
    private void    changebgColor(int position) {
        changePager(position);
        viewPager.setCurrentItem(current);
    }

    public void changePager(int position){
        //ViewPager //  基于  ListView
       //ViewPager2 //  基于  RecyclerView
//       buttons[current].setTextColor(Color.parseColor("#FFFFFF"));
        buttons[current].setTextColor(getResources().getColor(R.color.black));
       current = position;
       switch (position){
           case 0: buttons[current].setTextColor(Color.parseColor("#FC5531")); break;
           case 1: buttons[current].setTextColor(Color.parseColor("#FC5531")); break;
           case 2: buttons[current].setTextColor(Color.parseColor("#FC5531")); break;
           case 3: buttons[current].setTextColor(Color.parseColor("#FC5531")); break;
           case 4: buttons[current].setTextColor(Color.parseColor("#FC5531")); break;
       }
   }
//   View.OnClickListener
//    TextView
}
