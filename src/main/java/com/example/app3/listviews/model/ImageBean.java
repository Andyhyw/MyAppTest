package com.example.app3.listviews.model;

public class ImageBean {
    private int bitmapId;
    private String name;

    public ImageBean() {
    }

    public ImageBean(int bitmapId, String name) {
        this.bitmapId = bitmapId;
        this.name = name;
    }

    public int getBitmapId() {
        return bitmapId;
    }

    public void setBitmapId(int bitmapId) {
        this.bitmapId = bitmapId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
