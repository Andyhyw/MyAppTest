package com.example.app3.listviews.model;

import java.util.List;

public class TitleBean extends MultyBaseBean{
    private List<String> titles;//轮播的数据源一般都为数组。
    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }
}
