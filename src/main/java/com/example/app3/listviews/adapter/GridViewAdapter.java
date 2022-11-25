package com.example.app3.listviews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.listviews.model.ImageBean;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private List<ImageBean> data;//显示数据

    private Context context;//传入上下文

    public GridViewAdapter(List<ImageBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {//adapter优化
            //加载子布局
            view = LayoutInflater.from(context).inflate(R.layout.item_gridview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.image1);
            viewHolder.textView = (TextView) view.findViewById(R.id.text1);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(data.get(position).getBitmapId());
        viewHolder.textView.setText(data.get(position).getName());
        return view;
    }

    //adapter优化
    private class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}