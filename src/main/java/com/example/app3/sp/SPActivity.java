package com.example.app3.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app3.sp.sputils.Preferences;
import com.example.app3.sp.sputils.SharedPreferencesUtil;
import com.example.app3.sp.sputils.SharedPreferencesUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SPActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SPActivity";
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//TODO  activityForResult()  过时


       // spSave();//sp存储
       InnerSave();//内部存储
        //OuterSave();//外部存储

    }

    private void OuterSave() {
       new WriteToSD(this);

    }

    private void InnerSave() {
        String FILENAME = "hello_file.doc";
        String string = "hello world!";

        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);//字节流  字符流
            fos.write(string.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

/**TODO
 *  其他方法(都在Context类中)：
 *  getFilesDir() 获取在其中存储内部文件的文件系统目录的绝对路径。
 *  返回路径为：/data/data/com.xxx.xxx/files
 *  getDir()
 *  在您的内部存储空间内创建（或打开现有的）目录。如：
 *  getDir("hm", Context.MODE_PRIVATE).getAbsolutePath()
 *  返回结果： /data/data/com.xxx.xxx/app_mq, 我们看到系统自动给我们的文件名前加了app_
 *  deleteFile()
 *  删除保存在内部存储的文件。如：
 *  deleteFile("mh")
 *  删除/data/data/com.xxx.xxx/files目录中对应mh的文件，如果存在并删除成功，返回true；反之返回false。
 *  fileList()
 *  返回应用当前保存的一系列文件。
 *  同样也是列出 /data/data/com.xxx.xxx/files 目录下的所有的文件
 */

        Log.d(TAG,getFilesDir().toString());
        Log.d(TAG,getDir("hm", Context.MODE_PRIVATE).getAbsolutePath());
        Log.d(TAG,getDir("mh", Context.MODE_PRIVATE).getAbsolutePath());
        //deleteFile("mh");
        File dir = getFilesDir();
        File file = new File(dir,"mh");
        boolean deleted = file.delete();//TODO  删除不成功
        Log.d(TAG,deleted+"");
        Log.d(TAG,fileList().toString());



    }

    private void spSave() {
        putSp();//方式一
        //方式二  app注册
        SharedPreferencesUtil.putData("user1name","zhangsan");
        String user1name= (String)SharedPreferencesUtil.getData("user1name","zs");
        Log.d(TAG,user1name);

        //方式三  //不用初始化
//        SharedPreferencesUtils.setParam(this,"user2name","lisi");
//        String user2name=(String)SharedPreferencesUtils.getParam(this,"user2name","ls");
//        Log.d(TAG,user2name);

        // 方式四  APP注册
        Preferences.getPreferences().putString("user3name", "wangwu");
        String user3name = Preferences.getPreferences().getString("user3name", "ww");
        Log.d(TAG,user3name);
    }

    private void putSp() {
        //获得SharedPreferences的实例 sp_name是文件名
        SharedPreferences sp = getSharedPreferences("sp_data4", Context.MODE_PRIVATE);
        //获得Editor 实例
        SharedPreferences.Editor editor = sp.edit();
        //以key-value形式保存数据
        editor.putString("username", "zhaoliu");
        //apply()是异步写入数据
        editor.apply();
        //commit()是同步写入数据
        //editor.commit();

/**TODO
 *  SharedPreferences读取xml文件时，会以DOM方式解析（把整个xml文件直接加载到内存中解析），
 *  在调用getXXX()方法时取到的是内存中的数据，方法执行时会有个锁来阻塞，目的是等待文件加载完毕，
 *  没加载完成之前会wait()。
 *  SharedPreferences写文件时，如果调用的commit(),会将数据同步写入内存中，内存数据更新，
 *  再同步写入磁盘中;如果调用的apply(),会将数据同步写入内存中，内存数据更新，然后异步写人磁盘，
 *  也就是说可能写磁盘操作还没有完成就直接返回了。在主线程中建议使用apply()，因为同步写磁盘，
 *  当文件较大时，commit()会等到写磁盘完成再返回，可能会有ANR问题。
 *  SP第一次初始化到读取到数据存在一定延迟，因为需要到文件中读取数据，因此可能会对UI线程流畅度造成一定影响。
 *  Android---在主线程（UI线程）中 不能做太耗时的工作。
 *  Application Not Response（ANR）//卡顿  卡死   OOM //
 *  （NPE）NULL POINTER EXCEPTION
 *
 */

        //获得SharedPreferences的实例 sp_name是文件名
        SharedPreferences sp1 = getSharedPreferences("sp_data4", Context.MODE_PRIVATE);
        String data = sp1.getString("username", "zl");
        Log.d(TAG,data);
//      Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
//        System.out.println();
    }

    @Override
    public void onClick(View v) {

    }




}
