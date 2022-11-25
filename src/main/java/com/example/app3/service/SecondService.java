package com.example.app3.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class SecondService extends Service {
    private final IBinder binder = new SecondBinder();    //创建一个IBinder对象
    private final Random generator = new Random();    //声明并实例化一个Randrom对象

    //编写 一个继承自Binder的内部类
    public class SecondBinder extends Binder {
        SecondService getService() {
            return SecondService.this;
        }
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return binder;    //返回IBinder对象
    }

    //获取随机数的方法
    public int getRandomNumber() {
        return generator.nextInt(100);    //返回生成的随机数
    }
}
