package com.example.app3.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.app3.R;
import com.example.app3.service.anservice.StartService;

public class StartServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
        Button btn_start=(Button)findViewById(R.id.btn_start);	//获取“启动Service”按钮

         Intent intent=new Intent(StartServiceActivity.this, FirstService.class);	//创建Intent对象
        btn_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startService(intent);	//启动Service

            }
        });
        Button btn_stop=(Button)findViewById(R.id.btn_stop);	//获取“停止Service”按钮
        btn_stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                stopService(intent);		//停止Service

               // FirstService.getIncetence().stopSelf();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
//            Intent intent =new Intent();
//            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
