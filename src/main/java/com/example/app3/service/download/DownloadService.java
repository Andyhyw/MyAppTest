package com.example.app3.service.download;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import android.os.Environment;
import android.widget.Toast;

import com.example.app3.service.download.listener.DownloadListener;

import java.io.File;

import androidx.annotation.Nullable;

public class DownloadService extends Service {
        public DownloadService() {
        }
        private DownloadAsyncTask downloadTask;
        private MyBinder myBinder = new MyBinder();


        public class MyBinder extends Binder {
            void startDownload(String url, DownloadListener listener) {
                downloadTask = new DownloadAsyncTask(listener);
                downloadTask.execute(url);
            }
        }
        @Nullable
        @Override
        public IBinder onBind (Intent intent){
            return myBinder;
        }

}