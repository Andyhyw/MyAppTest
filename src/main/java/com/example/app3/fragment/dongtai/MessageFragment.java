package com.example.app3.fragment.dongtai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.interfce.MessageListener;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MessageFragment extends Fragment {
    private TextView mTvMessage;

    MessageListener mListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建接口的子类对象
        //获取当前Fragment所属的Activity,因为Activity实现了MessageListener接口，所以是MessageListener的子类
        mListener= (MessageListener) getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_message, null);
        mTvMessage = view.findViewById(R.id.tv_message);
        initView();
        mListener.sendMessage("来自：MessageFragment的消息");
        return view;
    }

    private void initView() {
        Bundle arguments = this.getArguments();
        String message = arguments.getString("message");
        mTvMessage.setText(message);

       CommunityFragment communityFragment=(CommunityFragment) getActivity().getSupportFragmentManager().findFragmentByTag("communityfragment");

        communityFragment.setTextView("f-f-msg");


    }
}