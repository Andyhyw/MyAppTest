package com.example.app3.listviews.ui;

import android.os.Bundle;

import com.example.app3.listviews.adapter.RecyclerViewSingleAdapter;
import com.example.app3.ui.MainActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewSingleActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView = new RecyclerView(this);
        setContentView(recyclerView);
        //true ；是否翻转 可以左右拖动 - 线性布局
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewSingleActivity.this, LinearLayoutManager.HORIZONTAL,true));
        //创建一个表格布局默认是垂直方向的可以上下
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        recyclerView.setAdapter(new RecyclerViewSingleAdapter());
    }
}
