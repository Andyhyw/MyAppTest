package com.example.app3.frgtofrgmsg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app3.R;
import com.example.app3.interfce.ICommuntyCallBack;
import com.example.app3.interfce.ILeftCallBack;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LeftFragment extends Fragment {
    private TextView mTvHome;
    private Button mBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home2, null);
        mTvHome = view.findViewById(R.id.tv_home);
        mBtn = view.findViewById(R.id.btn_home);
        mTvHome.setText("left");
        initView();
        return view;
    }
    private void initView() {
//        Bundle bundle = getArguments();
//        String string = bundle.getString("KK","");
//        mTvHome.setText(string);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RightFragment rightFragment = (RightFragment) getActivity().getSupportFragmentManager().findFragmentByTag("right");
                if (rightFragment == null) return;
                rightFragment.setTextView("right!!!!!!!!!!!!!!!");

               TextView textView= getActivity().findViewById(R.id.tv_community);
              String str= textView.getText().toString();

              Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
              TextView textView1=  getActivity().findViewById(R.id.tv_title);
              textView1.setText("lftmsg");

//            LeftFragment leftFragment=(LeftFragment)  getActivity().getSupportFragmentManager().findFragmentById(R.id.left);




            }
        });

    }


    public void setTextView(String str){
        mTvHome.setText(str);
    }

    public void sendMessage(ILeftCallBack iLeftCallBack){
        iLeftCallBack.getMessageFromLeft("我是来自LeftFragment的消息");
    }

}
