package com.example.app3.fragment.viewpagerfgmt.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.app3.R;
import com.example.app3.fragment.viewpagerfgmt.adapter.MyAdapter;
import com.example.app3.fragment.viewpagerfgmt.model.Row;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragmnet extends Fragment {
        ListView listView;
   static MyFragmnet myFragmnet;
    public static MyFragmnet getInstance(){
        if (myFragmnet ==null){
            myFragmnet = new MyFragmnet();
        }
        return myFragmnet;
    }

    List<Row> list = new LinkedList<>();
    public void initList(){
        Row r1 = new Row("昵称","大海");
        Row r2 = new Row("学号","19201123");
        Row r3 = new Row("电话","18279750070");
        Row r4 = new Row("二维码名片","大海");
        Row r5 = new Row("性别","男");
        Row r6 = new Row("生日","1998/01/06");
        Row r7 = new Row("地区","江西-南昌");
        this.list.add(r1);
        this.list.add(r2);
        this.list.add(r3);
        this.list.add(r4);
        this.list.add(r5);
        this.list.add(r6);
        this.list.add(r7);
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initList();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        View fragmentView= inflater.inflate(R.layout.fragment_my, container, false);
        listView = (ListView) fragmentView.findViewById(R.id.lv);
        MyAdapter myAdapter = new MyAdapter(list,fragmentView.getContext());
        listView.setAdapter(myAdapter);

        return fragmentView;


    }
}
