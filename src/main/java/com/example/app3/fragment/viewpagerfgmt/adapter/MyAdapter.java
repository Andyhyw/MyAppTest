package com.example.app3.fragment.viewpagerfgmt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.fragment.viewpagerfgmt.model.Row;

import java.util.LinkedList;
import java.util.List;

public class MyAdapter extends BaseAdapter {  //RecyclerView.ViewHolder
        List<Row> list = new LinkedList<>();
        Context context;
        TextView title,content;
        LinearLayout box;

//        public MyAdapter(Context context) {
//            initList();
//            this.context = context;
//        }

    public MyAdapter(List<Row> list, Context context) {
        this.list = list;
        this.context = context;
    }

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
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);

            }
            title = view.findViewById(R.id.title);
            content = view.findViewById(R.id.content);
            title.setText(list.get(i).getLabel());
            content.setText(list.get(i).getContent());

            if(i==7||i==8){
                box = view.findViewById(R.id.box);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                lp.setMargins(0, 20, 0, 0);
                box.setLayoutParams(lp);
            }
            return view;
        }


}
