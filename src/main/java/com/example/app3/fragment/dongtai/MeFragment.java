package com.example.app3.fragment.dongtai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.event.MainActEvent;
import com.example.app3.event.MainFgmtEvent;
import com.example.app3.interfce.ICommuntyCallBack;
import com.example.app3.interfce.IMeCallBack;
import com.example.app3.model.User;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MeFragment extends Fragment {

    private TextView mTvMe;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_me, null);
        mTvMe = view.findViewById(R.id.tv_me);
        initView();
        return view;
    }

    private void initView() {
//        Bundle bundle = this.getArguments();
//        String home = bundle.getString("me");
        mTvMe.setText("meee");
        mTvMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setName("鸿蒙");
                MainActEvent mainActEvent =new MainActEvent(user);
                EventBus.getDefault().post(mainActEvent);//new MainActEvent(user)
            }
        });
    }
    public void setTextView(String str) {
        //System.out.println("来自MeFragment传过来的消息" + str + "//");
        // mTvCommunity.setText(str);
        //if (str == null) return;
        mTvMe.setText(str);

    }



    public void sendMessage(IMeCallBack iMeCallBack){
        iMeCallBack.getMessageFromMe("我是来自MeFragment的消息");
    }
}