package com.example.app3.listviews.ui;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.app3.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {
        //创建RecyclerView
        private RecyclerView recyclerView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            recyclerView = new RecyclerView(this);
            //把它当做Activity的内容布局
            setContentView(recyclerView);
            LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this);
            linearLayoutManager.generateDefaultLayoutParams().height= (int)getResources().getDimension(R.dimen.tv_size);
            //设置RecyclerView的布局
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.HORIZONTAL));
            //为 RecyclerView填充内容 - 创建一个 Adapter - 需要重写三个函数
            recyclerView.setAdapter(new RecyclerView.Adapter() {
                //首先自定义一个类继承RecyclerView.ViewHolder 实现构造函数
                class ViewHoler extends RecyclerView.ViewHolder{
                    // 在ViewHolder 里面绑定子对象的视图
                    private TextView tv;
                    public ViewHoler(TextView itemView) {
                        super(itemView);
                        tv = itemView;//通过这种方式 TextView就可以跟ViewHolder进行关联
                    }
                    //在外界公开一个函数 getTV（) ,用它来返回这个TextView
                    public TextView getTV(){
                        return tv;
                    }
                }
                //创建 ViewHolder的方法
                  @Override
                  public RecyclerView.ViewHolder onCreateViewHolder(
                            ViewGroup parent, int viewType) {
                                return new ViewHoler(new TextView(parent.getContext()));
                            }
                            //onBindViewHolder 可以对TextView进行赋值， - 在外界进行配置
                            @Override
                            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                                ViewHoler vh = (ViewHoler) holder;
                                vh.getTV().setText("Item " + position);
                            }
                            //获取RecyclerView子对象的数量
                            @Override
                            public int getItemCount() {
                                return 1000;
                            }
                        });
                    }
}
