package com.example.app3.service.download;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.service.download.listener.DownloadListener;

public class DownLoadActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    private TextView text;
    private ProgressBar progressBar;
    private Button cancel;
    private ImageView ivPicture;

    private DownloadListener listener;
    private DownloadService.MyBinder binder;
    private DownloadService service;

    //可以更换
    final static String URL_STRING = //"https://developer.android.google.cn/images/service_lifecycle.png";
               "https://img-blog.csdnimg.cn/img_convert/f538b09600741dd31645d1ad32dc0105.png";
//            "http://n1.itc.cn/img8/wb/recom/2016/04/26/146164046862104328.JPEG";
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            binder = (DownloadService.MyBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load);
        initViews();
        initListener();
        initService();
    }

    private void initService() {
        // 点击进行捆绑和操作
        Intent intent = new Intent(DownLoadActivity.this,DownloadService.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }

    private void startDownload() {
        binder.startDownload(URL_STRING,listener);
    }

    private void initListener() {
        listener = new DownloadListener() {
            @Override
            public void processDownload(int i) {
                text.setText(String.valueOf(i));
                progressBar.setProgress(i);
            }

            @Override
            public void success() {
                //成功就设置图片
                ivPicture.setImageBitmap(DownloadAsyncTask.loadBitmap);
                text.setText("下载成功");
            }

            @Override
            public void failure() {
                //失败就展示失败的文字
                text.setText("Download fail");
            }
        };
    }

    private void initViews() {
        button = findViewById(R.id.button);
        text = findViewById(R.id.text);
        progressBar = findViewById(R.id.progress_bar);
        cancel = findViewById(R.id.cancel);
        ivPicture = findViewById(R.id.iv_picture);
        button.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }
    static Boolean isCancel = false;
    @Override
    public void onClick(View view) {
        switch(view.getId()) {

            case R.id.button:
                startDownload();
                break;
            case R.id.cancel:
                // 图片取消
                if(!isCancel){
                    ivPicture.setVisibility(View.INVISIBLE);
                    cancel.setText("展示图片");
                    isCancel = true;
                }else {
                    ivPicture.setVisibility(View.VISIBLE);
                    cancel.setText("不展示图片");
                    isCancel = false;
                }

                break;
        }
    }
}