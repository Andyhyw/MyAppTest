package com.example.app3.listviews.ui;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import com.example.app3.R;
import com.example.app3.listviews.adapter.GridViewAdapter;
import com.example.app3.listviews.model.ImageBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import androidx.appcompat.app.AppCompatActivity;
public class GridViewActivity extends AppCompatActivity {

    private GridView gridView;
    List<ImageBean> data = new ArrayList<>();

    ImageBean bean;
    GridViewAdapter gridViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        //initView1();
        intiView2();
    }

    public void initView1(){

        gridView = findViewById(R.id.id_gridView);
        //图片数据
        int[] images = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
        //图片编号
        String[] name = {"No_1", "No_2", "No_3", "No_4", "No_5", "No_6",
                "No_7", "No_8", "No_9"};
        //初始化数据
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("ItemImage", images[i]);

            map.put("ItemText", name[i]);
            data.add(map);
        }

        String[] itemname = {"ItemImage", "ItemText"};
        int[] item = {R.id.image1, R.id.text1};
        //实例化一个适配器
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item, itemname, item);
        //为GridView设置适配器
        gridView.setAdapter(adapter);
    }


    public void intiView2(){

        gridView = findViewById(R.id.id_gridView);
        //图片数据
        int[] images = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
        //图片编号
        String[] name = {"No_1", "No_2", "No_3", "No_4", "No_5", "No_6",
                "No_7", "No_8", "No_9"};


        //初始化数据
        for (int i = 0; i < images.length; i++) {
            bean = new ImageBean(images[i], name[i]);
            data.add(bean);
        }
        //实例化适配器
        gridViewAdapter = new GridViewAdapter(data, this);

        //设置适配器
        gridView.setAdapter(gridViewAdapter);
    }
}
