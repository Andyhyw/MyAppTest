package com.example.app3.listviews.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app3.R;
import com.example.app3.listviews.adapter.NewsAdapter;
import com.example.app3.listviews.adapter.NewsAdapter2;
import com.example.app3.listviews.model.News;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {
    
  private List<News> mData = null;
  private Context mContext;
  private NewsAdapter mAdapter = null;
  private SimpleAdapter simpleAdapter=null;
  private ListView listView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.listview_layout);
    mContext = this;
    listView = (ListView)findViewById(R.id.listview);
    mData = new LinkedList<News>();
    for (int i = 0; i < 10; i++) {
      mData.add(new News("新闻标题---- " + i, "新闻内容---- " + i, R.mipmap.news));
     }
    mAdapter = new NewsAdapter(mData, mContext);

    mAdapter.setButtonClickListener(new NewsAdapter.OnButtonClickListener() {
      @Override
      public void onButtonClick(int position, Button button) {
        mData.remove(position);
        mAdapter.notifyDataSetChanged();
      }
    });

    listView.setAdapter(mAdapter);

//    simpleAdapter();


    listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
      @Override
      public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext, "长按点击了第" + (position+1) + "条数据id==="+id,Toast.LENGTH_SHORT).show();

        return false;
      }
    });

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext, "点击了第" + (position+1) + "条数据id==="+id,Toast.LENGTH_SHORT).show();
        TextView textView=view.findViewById(R.id.tv_title);
        textView.setText("pwpwppwpwpwpwpwpw");
      }
    });



  }






  private String[] titles = new String[]{"标题1", "标题2", "标题3"};
  private String[] contents = new String[]{"内容11，22", "内容33~", "内容44~"};
  private int[] imgIds = new int[]{R.mipmap.ic_launcher, R.mipmap.wenhao, R.mipmap.news};

  public void simpleAdapter(){

    List<Map<String, Object>> stringList = new ArrayList<Map<String, Object>>();
    for (int i = 0; i < titles.length; i++) {
      Map<String, Object> showitem = new HashMap<String, Object>();
      showitem.put("图像", imgIds[i]);//TODO SimpleAdapter 传图像
      showitem.put("标题", titles[i]);
      showitem.put("内容", contents[i]);
      stringList.add(showitem);
    }
    int[] itemId ={R.id.tv_t,R.id.tv_title,R.id.tv_content};
    String[] strings ={"图像","标题","内容"};

    //todo cahkan
    simpleAdapter =new SimpleAdapter(mContext, stringList,R.layout.item_simple_adpter,strings,itemId);

    listView.setAdapter(simpleAdapter);
  }
}
