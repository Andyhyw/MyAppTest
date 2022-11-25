package com.example.app3.service.download.listener;

public interface DownloadListener {
    void processDownload(int i);
    void success();
    void failure();
}
