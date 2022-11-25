package com.example.app3.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.app3.R;
import com.example.app3.service.anservice.StartService;

public class BindServiceActivity extends AppCompatActivity {
        boolean bound = false;		//标记是否绑定的变量
        SecondService secondService;		//声明一个MyService对象
        private ServiceConnection connection = new ServiceConnection() {
            public void onServiceConnected(ComponentName className, IBinder service) {
                SecondService.SecondBinder binder = (SecondService.SecondBinder) service;
                secondService = binder.getService();	//获取Service实例
                bound = true;		//标记已经绑定
            }
            public void onServiceDisconnected(ComponentName arg0) {
                bound = false;		//标记未绑定
            }
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bind_service);
        }

        @Override
        protected void onStart() {
            super.onStart();
            Intent intent = new Intent(this, SecondService.class);
            bindService(intent, connection, Context.BIND_AUTO_CREATE);	//绑定Service

        }

        @Override
        protected void onStop() {
            super.onStop();
            if (bound) {
                unbindService(connection);		//取消绑定的Service
                bound = false;
            }
        }
        //编写一个按钮的单击事件调用的方法
        public void onButtonClick(View v) {
            if (bound) {
                int num = secondService.getRandomNumber();
                Log.i("BindServiceActivity", "获得随机数：" + num);	//向LogCat中输出获取的随机数
            }
        }








//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            // Inflate the menu; this adds items to the action bar if it is present.
//            getMenuInflater().inflate(R.menu.main, menu);
//            return true;
//        }
//
//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            // Handle action bar item clicks here. The action bar will
//            // automatically handle clicks on the Home/Up button, so long
//            // as you specify a parent activity in AndroidManifest.xml.
//            int id = item.getItemId();
//            if (id == R.id.action_settings) {
//                return true;
//            }
//            return super.onOptionsItemSelected(item);
//        }
    }

