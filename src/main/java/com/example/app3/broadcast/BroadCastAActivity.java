package com.example.app3.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.app3.R;

public class BroadCastAActivity extends AppCompatActivity {

    private ABroadCastReceiver aBroadCastReceiver;

    private class  ABroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("")){
                //todo sth
            }

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_aactivity);
        registerReceiver(aBroadCastReceiver,null);
    }


    @Override
    protected void onDestroy() {
        unregisterReceiver(aBroadCastReceiver);
        super.onDestroy();
    }
}