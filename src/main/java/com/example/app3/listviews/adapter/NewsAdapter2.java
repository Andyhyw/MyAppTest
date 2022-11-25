package com.example.app3.listviews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.listviews.model.News;

import java.util.List;

public class NewsAdapter2 extends BaseAdapter {
    private List<News> mData;
    private Context mContext;


    public NewsAdapter2(List<News> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
    if (convertView == null) {
      convertView =LayoutInflater.from(mContext).inflate(R.layout.item_listview_layout, parent, false);
      holder =new ViewHolder();
      holder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
      holder.title = (TextView) convertView.findViewById(R.id.tv_title);
      holder.content = (TextView) convertView.findViewById(R.id.tv_content);
      holder.btn_adpt=(Button)convertView.findViewById(R.id.btn_adpt);
      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }

    holder.img_icon.setBackgroundResource(mData.get(position).getaIcon());
    holder.title.setText(mData.get(position).getTitle());
    holder.content.setText(mData.get(position).getContent());
//    holder.btn_adpt.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//        }
//    });
    return convertView;
    }

     class ViewHolder{
          ImageView img_icon;
          TextView title;
          TextView content;
          Button btn_adpt;
     }


}
