package com.example.app3.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app3.R;
import com.example.app3.service.aidl.AIDLActivity;
import com.example.app3.service.anservice.MessengerService;
import com.example.app3.service.anservice.StartService;
import com.example.app3.service.download.DownLoadActivity;

public class MainServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainServiceActivity.this, StartServiceActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainServiceActivity.this, BindServiceActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.aidl_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainServiceActivity.this, AIDLActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.download_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainServiceActivity.this, DownLoadActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.handler_ac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainServiceActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });

    }
}