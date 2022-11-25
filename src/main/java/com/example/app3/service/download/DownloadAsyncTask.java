package com.example.app3.service.download;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.example.app3.service.download.listener.DownloadListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadAsyncTask extends AsyncTask<String,Integer,Boolean> {

    public static String filePath = "";
    public static Bitmap loadBitmap;
    // 下载成功
    public static final int TYPE_SUCCESS = 0;
    // 下载失败
    public static final int TYPE_FAILED = 1;
    // 下载暂停
    public static final int TYPE_PAUSED = 2;
    // 下载取消
    public static final int TYPE_CANCELED = 3;
    // 下载状态监听回调
    private DownloadListener listener;
    // 是否取消
    private boolean isCancelled = false;
    // 是否暂停
    private boolean isPaused = false;
    // 当前进度
    private int lastProgress;

    public DownloadAsyncTask(DownloadListener downloadListener) {
        this.listener = downloadListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /**
     * 文件下载使用到第三方的okhttp
     */
    @Override
    protected Boolean doInBackground(String... strings) {

        // 文件输入流
        InputStream is = null;
        RandomAccessFile accessFile = null;
        File file = null;
        // 记录已下载的文件长度
        long downloadedLength = 0;
        // 获取下载的URL地址
        String downloadUrl = strings[0];
        // 从URL下载地址中截取下载的文件名
        String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
        // 获取SD卡的Download 目录
        String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        //  得到要保存的文件
        filePath = directory + fileName;
        file = new File(filePath);
        // 如果文件已经存在  获取文件的长度
        if (file.exists()) {
            downloadedLength = file.length();
        }
        try {
            //   获取待下载文件的字节长度
            long contentLength = getContentLength(downloadUrl);
            //  如果待下载文件的字节长度为0 说明待下载文件有问题
            if (contentLength == 0) {
                return false;
            } else if (contentLength == downloadedLength) {
                //   已下载字节和文件总字节相等 说明已经下载完了
                return true;
            }
            //  获取OkHttpClient 对象
            OkHttpClient client = new OkHttpClient();
            //  创建请求
            Request request = new Request.Builder()
                    //  断点下载，指定从哪个字节开始下载
                    .addHeader("RANGE", "bytes=" + downloadedLength + "-")
                    // 设置下载地址
                    .url(downloadUrl)
                    .build();
            //  获取响应
            Response response = null;
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (response != null) {
                // 读取服务器响应的数据
                is = response.body().byteStream();
                // 获取随机读取文件类  可以随机读取一个文件中指定位置的数据
                accessFile = new RandomAccessFile(file, "rw");
                // 跳过已下载的字节
                accessFile.seek(downloadedLength);
                //指定每次读取文件缓存区的大小为1KB
                byte[] b = new byte[1024];
                int total = 0;
                int len;
                //   每次读取的字节长度
                while ((len = is.read(b)) != -1) {
                    // 读取的全部字节的长度
                    total += len;
                    // 写入每次读取的字节长度
                    accessFile.write(b, 0, len);
                    // 计算已下载的百分比
                    int progress = (int) ((total + downloadedLength) * 100 / contentLength);
                    // 更新进度条
                    publishProgress(progress);
                }
                // 关闭连接  返回成功
                response.body().close();
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭输入流
                if (is != null) {
                    is.close();
                }
                // 关闭文件
                if (accessFile != null) {
                    accessFile.close();
                }
                Log.d("TAG", "关闭资源 ");
                // 如果是取消的  就删除掉文件
                if (isCancelled && file != null) {
                    file.delete();
                }
                FileInputStream fileInputStream = new FileInputStream(filePath);
                loadBitmap = BitmapFactory.decodeStream(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 辅助类工具类，但是我觉得这样写并不是很好，应该一个网络连接即可，又构造一个浪费时间！！后续可以改改
     *
     * @param downloadUrl
     * @return
     * @throws IOException
     */
    private long getContentLength(String downloadUrl) throws IOException {
        // 获取OkHttpClient
        OkHttpClient client = new OkHttpClient();
        // 创建请求
        Request request = new Request.Builder()
                .url(downloadUrl)
                .build();
        //  获取响应
        Response response = client.newCall(request).execute();
        //  如果响应是成功的话
        if (response != null && response.isSuccessful()) {
            // 获取文件的长度  清除响应
            long contentLength = response.body().contentLength();
            response.close();
            return contentLength;
        }
        return 0;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        listener.processDownload(values[0]);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if (aBoolean) {
            listener.success();
        } else {
            listener.failure();
        }
    }
}