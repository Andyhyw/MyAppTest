package com.example.app3.fragment.dongtai;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.interfce.ICommuntyCallBack;
import com.example.app3.interfce.IHomeCallBack;
import com.example.app3.interfce.IMeCallBack;
import com.example.app3.interfce.MessageListener;

import java.util.ArrayList;
import java.util.List;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
public class MainDongtaiActivity extends FragmentActivity implements MessageListener {

    private FrameLayout mFrameLayout;
    private RadioGroup mRg;
    private RadioButton mRbHome;
    private RadioButton mRbCommunity;
    private RadioButton mRbMessage;
    private RadioButton mRbMe;
    private List<Fragment> mFragments = new ArrayList<>();
    private HomeFragment homeFragment;//首页
    private CommunityFragment communityFragment;//社区
    private MessageFragment messageFragment;//消息
    private MeFragment meFragment;//我的
    private FragmentManager mSupportFragmentManager;
    private FragmentTransaction mTransaction;

    private TextView mTvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dactivity);
        mFrameLayout = findViewById(R.id.frameLayout);
        mRg = findViewById(R.id.rg_main);
        mRbHome = findViewById(R.id.rb_home);
        mRbCommunity = findViewById(R.id.rb_community);
        mRbMessage = findViewById(R.id.rb_message);
        mRbMe = findViewById(R.id.rb_me);
        mTvMain=findViewById(R.id.tv_main);
        initView();

        //todo 传参
        initData();
    }
    private void initData() {
        homeFragment.sendMessage(new IHomeCallBack() {
            @Override
            public void getMessageFromHomeFragment(String home) {
                mTvMain.setText(home);
            }
        });

    }

    private void initView() {
        mSupportFragmentManager = getSupportFragmentManager();
        mTransaction = mSupportFragmentManager.beginTransaction();
        //设置默认选中首页
        mRg.check(R.id.rb_home);
        homeFragment = new HomeFragment();

        //创建Bundle对象，并存储数据  //todo 传递数据
        Bundle bundle=new Bundle();
        bundle.putString("home","Home");
        homeFragment.setArguments(bundle);

        mFragments.add(homeFragment);
        hideOthersFragment(homeFragment, true,"homefragment");
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home: //首页
                        hideOthersFragment(homeFragment, false,"homefragment");
                        break;
                    case R.id.rb_community: //社团
                        if (communityFragment == null) {
                            communityFragment = new CommunityFragment();

                            //todo 传参
                            Bundle bundle=new Bundle();
                            bundle.putString("community","Community");
                            communityFragment.setArguments(bundle);


                            mFragments.add(communityFragment);
                            hideOthersFragment(communityFragment, true,"communityfragment");
                        } else {
                            hideOthersFragment(communityFragment, false,"communityfragment");
                        }

                        //todo 传参
                        communityFragment.sendMessage(new ICommuntyCallBack() {
                            @Override
                            public void getMessageFromCommunty(String community) {
                                mTvMain.setText(community);
                            }
                        });
                        break;
                    case R.id.rb_message: //信息
                        if (messageFragment == null) {
                            messageFragment = new MessageFragment();

                            //todo 传参
                            Bundle bundle=new Bundle();
                            bundle.putString("message","Message");
                            messageFragment.setArguments(bundle);

                            mFragments.add(messageFragment);
                            hideOthersFragment(messageFragment, true,"messagefragment");
                        } else {
                            hideOthersFragment(messageFragment, false,"messagefragment");
                        }
                        break;
                    case R.id.rb_me: //我的
                        if (meFragment == null) {
                            meFragment = new MeFragment();

                            //TODO 传参
                            Bundle bundle=new Bundle();
                            bundle.putString("me","Me");
                            meFragment.setArguments(bundle);

                            mFragments.add(meFragment);
                            hideOthersFragment(meFragment, true,"mefragment");
                        } else {
                            hideOthersFragment(meFragment, false,"mefragment");
                        }

                        meFragment.sendMessage(new IMeCallBack() {
                            @Override
                            public void getMessageFromMe(String me) {
                                mTvMain.setText(me);
                            }
                        });
                        break;
                }
            }
        });
    }


    private void hideOthersFragment(Fragment showFragment, boolean add,String tag) {
        mTransaction = mSupportFragmentManager.beginTransaction();
        if (add) {
            mTransaction.add(R.id.frameLayout, showFragment,tag);
        }
        for (Fragment fragment : mFragments) {
            if (showFragment.equals(fragment)) {
                mTransaction.show(fragment);
            } else {
                mTransaction.hide(fragment);
            }
        }

        mTransaction.commit();
    }

    @Override
    public void sendMessage(String message) {
        mTvMain.setText(message);
        CommunityFragment communityfragment = (CommunityFragment) mSupportFragmentManager.findFragmentByTag("communityfragment");
//        communityfragment.setTextView(message);
        communityfragment.setTextView(message);

    }
}