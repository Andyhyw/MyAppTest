package com.example.app3.listviews.ui;

import android.content.Context;
import android.os.Bundle;

import com.example.app3.R;
import com.example.app3.listviews.adapter.RecyclerViewMultyAdapter;
import com.example.app3.listviews.model.BodyBean;
import com.example.app3.listviews.model.FootBean;
import com.example.app3.listviews.model.MultyBaseBean;
import com.example.app3.listviews.model.TitleBean;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyvlerViewMultyActivity extends AppCompatActivity {

    Context context;
    private RecyclerViewMultyAdapter adapter;
    private List<MultyBaseBean> mlist = new ArrayList<>();
    private RecyclerView rv;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_multy);
        context = this;
        rv = findViewById(R.id.rv_multy);
        initTitle();
        initBody();
        initFoot();
        initAdapter();
    }


    private void initFoot() {
        for (int i = 0; i < 20; i++) {
            FootBean footBean=new FootBean("foot:"+i);
            footBean.setViewType(RecyclerViewMultyAdapter.FOOT);//正常列表
            mlist.add(footBean);
        }
    }

    private void initBody() {
        List<Integer> res = new ArrayList<>(6);
        res.add(R.mipmap.ima);
        res.add(R.mipmap.p2);
        res.add(R.mipmap.p3);
        res.add(R.mipmap.p4);
        res.add(R.mipmap.p5);
        res.add(R.mipmap.p6);
        BodyBean bodyBean = new BodyBean();
        bodyBean.setRes(res);
        bodyBean.setViewType(RecyclerViewMultyAdapter.BODY);//设置横向列表的类型
        mlist.add(bodyBean);
    }

    private void initTitle() {
        List<String> titles = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            titles.add(new StringBuilder("标题").append(i).toString());
        }
        TitleBean titleBean = new TitleBean();
        titleBean.setTitles(titles);
        titleBean.setViewType(RecyclerViewMultyAdapter.TITLE);//设置为轮播类型
        mlist.add(titleBean);
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new RecyclerViewMultyAdapter(mlist);
            rv.setLayoutManager(new LinearLayoutManager(context));
            rv.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

}
