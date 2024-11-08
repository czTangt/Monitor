package com.cztang.monitor.Domain;

public class OngoingDomain {
    private String title;
    private String data;
    private int progressPercent;
    private String picPath;

    public OngoingDomain(String title, String data, int progressPercent, String picPath) {
        this.title = title;
        this.data = data;
        this.progressPercent = progressPercent;
        this.picPath = picPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(int progressPercent) {
        this.progressPercent = progressPercent;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
