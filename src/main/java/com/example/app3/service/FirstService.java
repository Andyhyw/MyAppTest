package com.example.app3.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FirstService extends Service {
    private static final String TAG = "FirstService";

    //必须实现的方法
    @Override
    public IBinder onBind(Intent arg0) {
        // TODO 自动生成的方法存根
        return null;
    }
    //Service被创建时回调
    @Override
    public void onCreate() {
        Log.i("Service","onCreate()方法被调用");
        super.onCreate();
    }
    //Service被关闭之前回调，通常用于清理资源
    @Override
    public void onDestroy() {
        Log.i("Service","onDestroy()方法被调用");
        super.onDestroy();
    }
    //Service被启动时回调
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("Service","onStartCommand()方法被调用");
        Thread thread =new Thread();//开辟新的线程
        thread.start();


        stopSelf();

        return super.onStartCommand(intent, flags, startId);
    }


}