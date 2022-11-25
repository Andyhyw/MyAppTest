package com.example.app3.listviews.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.app3.R;
import com.example.app3.listviews.adapter.RecyclerViewAdapter;
import com.example.app3.listviews.model.News;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class RecyclerViewActivity2 extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private List<News> mList = new ArrayList<>();
    private List<News> mData = null;

    private RecyclerViewAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview2);
        initData();
        initRecyclerView();
    }

    private void initData() {
//        List<News>  mData= XXXXDao.queryAll();
        mData = new LinkedList<News>();
        for (int i = 0; i < 40; i++) {
            mData.add(new News("新闻标题---- " + i, "新闻内容---- " + i, R.mipmap.news));
        }

        Log.i(TAG, "initData: mList:::" + mList);

    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,3);//GrideView
        StaggeredGridLayoutManager staggeredGridLayoutManager =new StaggeredGridLayoutManager(4,RecyclerView.VERTICAL);

        mRecyclerView = findViewById(R.id.recycler_view);
        myAdapter = new RecyclerViewAdapter(RecyclerViewActivity2.this,mData);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(myAdapter);



        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        //添加Android自带的分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        // RecyclerView比ListView相比优点在于可定制强，
        // 也正是由于RecyclerView的可定制性太强，好多功能实现都需要自己来写，
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//设置增加删除动画
        // RecyclerView不像ListView给开发者提供了setOnItemClickListener()方法，但是要实现监听也不难实现，
        myAdapter.setOnRecyclerViewListener(new RecyclerViewAdapter.onRecyclerViewListener() {
            @Override
            public void editHeadIcon(int position) {
                showToast("点击了头像编辑");
            }

            @Override
            public void deleteInfo(int position) {
                if (position < mData.size() && position >= 0) {

                    News news =mData.get(position);
//                  int row=  XXXDao.delete(2);//EventBus
//                    if (row > 0){
                        mData.remove(position);
                        myAdapter.notifyDataSetChanged();
//                    }

//                   news= myAdapter.getItem(position);
                }else {
                    showToast("error!");
                }
            }
        });
    }


    private void showToast(String str) {
        Toast.makeText(RecyclerViewActivity2.this, str, Toast.LENGTH_SHORT).show();
    }
}
