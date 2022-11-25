package com.example.app3.frgtofrgmsg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.interfce.ILeftCallBack;
import com.example.app3.interfce.IRightCallBack;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RightFragment extends Fragment {

    private TextView mTvCommunity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, null);
        mTvCommunity=view.findViewById(R.id.tv_community);
        initView();
        return view;
    }
    private void initView() {
        Bundle bundle = this.getArguments();
//        String community = bundle.getString("community","community");
//        mTvCommunity.setText(community);
    }
    public void setTextView(String str){
        mTvCommunity.setText(str);
    }

    public void sendMessage(IRightCallBack iRightCallBack){
        iRightCallBack.getMessageFromRight("我是来自RightFragment的消息");
    }


}
