package com.example.app3.sp;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class WriteToSD {
    private Context context;
    String filePath = android.os.Environment.getExternalStorageDirectory()+"/music1";
    public WriteToSD(Context context){
        this.context = context;
        if(!isExist()){
            write();
        }
    }
    private void write(){
        InputStream inputStream;
        try {
            inputStream = context.getResources().getAssets().open("h.mp3");
            File file = new File(filePath);
            if(!file.exists()){
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(filePath + "/h.mp3");
            byte[] buffer = new byte[512];
            int count = 0;
            while((count = inputStream.read(buffer)) > 0){
                fileOutputStream.write(buffer, 0 ,count);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            inputStream.close();
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean isExist(){
        File file = new File(filePath + "/h.mp3");
        if(file.exists()){
            return true;
        }else{
            return false;
        }
    }
}
