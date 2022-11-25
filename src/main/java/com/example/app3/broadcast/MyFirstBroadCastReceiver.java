package com.example.app3.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

public class MyFirstBroadCastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyFirstBroadCast";
  // 静态注册时候的action、发送广播时的action、接收广播时的action，三者需要保持一致

   public static final String SHOCK_ACTION = "com.example.bc1";
    @Override
    public void onReceive(Context context, Intent intent) {
            //打开手机振动    、、 打开手电筒   、、、、、
        if (intent.getAction().equals(SHOCK_ACTION)){
      Vibrator vb = (Vibrator)

      context.getSystemService(Context.VIBRATOR_SERVICE);
      vb.vibrate(500); // 命令震动器吱吱个若干秒，这里的500表示500毫秒

    }

    }
}
