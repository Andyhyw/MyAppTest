package com.example.app3.fragment.viewpagerfgmt.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app3.R;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BlankFragment extends Fragment {

     String mTitle ;
     static  final  String params ="params";
  static   BlankFragment blankFragment;
    public static BlankFragment newInstance(String title){
//        mTitle =title;
//        if (blankFragment ==null){
        BlankFragment   blankFragment = new BlankFragment();
            Bundle bundle =new Bundle();
            bundle.putString(params,title);
            blankFragment.setArguments(bundle);
//        }
        return blankFragment;
    }

//    public static BlankFragment getInstance(String title){//单例  单汉   饿汉  线程安全的
////        mTitle =title;
//        if (blankFragment ==null){
//           blankFragment = new BlankFragment();
//        Bundle bundle =new Bundle();
//        bundle.putString(params,title);
//        blankFragment.setArguments(bundle);
//        }
//        return blankFragment;
//    }

    View view;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle =getArguments();
        if (bundle !=null){
            mTitle =bundle.getString(params);
        }


    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_blank,container,false);
        initView();
        return view;
    }


    private void initView() {
        TextView textView = view.findViewById(R.id.text);
        textView.setText(mTitle);
    }
}
