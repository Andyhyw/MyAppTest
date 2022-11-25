package com.example.app3;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.example.app3.room.UserDataBase;
import com.example.app3.sp.sputils.Preferences;
import com.example.app3.sp.sputils.SharedPreferencesUtil;

import androidx.room.Room;

public class BaseApplication extends Application {
    private static final String TAG = "BaseApplication";
    @Override
    public void onCreate() {
        // 程序创建的时候执行
        Log.d(TAG, "onCreate");
        super.onCreate();
        //方式一
        SharedPreferencesUtil.getInstance(this,"sp_data1");

        //方式四
        Preferences.init(this);

        //app3上下文环境
        //todo linux  linucJC(Dalvik(app3(act1(this\onclick(this))\act2(this)\....)))




           }


    @Override
    public void onTerminate() {
        // 程序终止的时候执行
        Log.d(TAG, "onTerminate");
        super.onTerminate();
    }
    @Override
    public void onLowMemory() {
        // 低内存的时候执行
        Log.d(TAG, "onLowMemory");
        super.onLowMemory();
    }
    @Override
    public void onTrimMemory(int level) {
        // 程序在内存清理的时候执行
        Log.d(TAG, "onTrimMemory");
        super.onTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

//    public static Context getContext(){
//        return  Application.;
//    }


}
