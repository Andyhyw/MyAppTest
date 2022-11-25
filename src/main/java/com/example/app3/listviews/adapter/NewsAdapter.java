package com.example.app3.listviews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.listviews.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends BaseAdapter {
  private List<News> mData;
  private Context mContext;

  private View.OnClickListener listener;
  private int mPosition;

  public NewsAdapter(List<News> mData, Context mContext) {
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
    mPosition =position;
    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_listview_layout,parent, false);
    ImageView img_icon = (ImageView)convertView.findViewById(R.id.img_icon);
    TextView  title = (TextView)convertView.findViewById(R.id.tv_title);
    TextView  content = (TextView)convertView.findViewById(R.id.tv_content);
    TextView  btn_adpt = (TextView)convertView.findViewById(R.id.btn_adpt);

    News news=mData.get(position);
    img_icon.setBackgroundResource(news.getaIcon());
    title.setText(news.getTitle());
    content.setText(news.getContent());
    btn_adpt.setOnClickListener(btnClickListener);
    btn_adpt.setTag(position);

    return convertView;
  }




  public interface OnButtonClickListener {
    public void onButtonClick(int position, Button button);
  }
  private OnButtonClickListener buttonClickListener;//接口一个很重要的作用---回调
  public void setButtonClickListener(OnButtonClickListener buttonClickListener) {
    this.buttonClickListener = buttonClickListener;
  }
  private View.OnClickListener btnClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      if (buttonClickListener != null) {
        int position = (Integer) v.getTag();
        Button button = (Button) v;
        buttonClickListener.onButtonClick(position, button);
      }
    }
  };

}
