package com.example.app3.fragment.viewpagerfgmt.model;

public class Row {
    private String label;
    private String content;

    public Row() {
    }

    public Row(String label, String content) {
        this.label = label;
        this.content = content;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
