package com.example.app3.fragment.dongtai;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.interfce.IHomeCallBack;

public class HomeFragment extends Fragment {

    private TextView mTvHome;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home2, null);
        mTvHome = view.findViewById(R.id.tv_home);
        Button btn =view.findViewById(R.id.btn_home);
        btn.setVisibility(View.GONE);
        initView();
        return view;
    }


    private void initView() {
        Bundle bundle = this.getArguments();
        String home = bundle.getString("home");
        mTvHome.setText(home);
    }

    public void setTextView(String str) {
        //System.out.println("来自HomeFragment传过来的消息" + str + "//");
        // mTvCommunity.setText(str);
        //if (str == null) return;
        mTvHome.setText(str);

    }
//设置接口回调方法
    public void sendMessage(IHomeCallBack iHomeCallBack){
        iHomeCallBack.getMessageFromHomeFragment("我是来自HomeFragment的消息");
    }

}