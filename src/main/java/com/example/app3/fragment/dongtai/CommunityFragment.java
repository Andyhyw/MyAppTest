package com.example.app3.fragment.dongtai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.interfce.ICommuntyCallBack;
import com.example.app3.interfce.IHomeCallBack;

import androidx.fragment.app.Fragment;

public class CommunityFragment extends Fragment {

    private TextView mTvCommunity;
    public static final String TAG = "CommunityFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_community, null);
        mTvCommunity = view.findViewById(R.id.tv_community);
        initView();
        return view;
    }
    private void initView() {
        Bundle bundle = this.getArguments();
        String community = bundle.getString("community");
         mTvCommunity.setText(community);
    }



    public void setTextView(String str) {
        //System.out.println("来自CommunityFragment传过来的消息" + str + "//");
        // mTvCommunity.setText(str);
        //if (str == null) return;
        mTvCommunity.setText(str);

    }

    public void sendMessage(ICommuntyCallBack iCommuntyCallBack){
        iCommuntyCallBack.getMessageFromCommunty("我是来自CommunityFragment的消息");
    }


}