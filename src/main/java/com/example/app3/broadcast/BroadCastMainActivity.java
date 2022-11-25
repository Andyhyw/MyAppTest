package com.example.app3.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.app3.R;

public class BroadCastMainActivity extends AppCompatActivity  {
    TextView btn_bc_vibrate;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_main);


//        Intent intent =new Intent();
//        intent.setAction("");
//        sendBroadcast(intent);
//        sendOrderedBroadcast();

        btn_bc_vibrate=findViewById(R.id.btn_bc_vibrate);
        btn_bc_vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String receiverPath = "com.example.app3.broadcast.MyFirstBroadCastReceiver";
                Intent intent = new Intent(MyFirstBroadCastReceiver.SHOCK_ACTION); // 创建一个指定动作的意图
                // 发送静态广播之时，需要通过setComponent方法指定接收器的完整路径
                ComponentName componentName = new ComponentName(mContext, receiverPath);
                intent.setComponent(componentName); // 设置意图的组件信息
                sendBroadcast(intent); // 发送静态广播
            }
        });




    }
}