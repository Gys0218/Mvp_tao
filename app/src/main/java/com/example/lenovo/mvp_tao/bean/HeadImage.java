package com.example.lenovo.mvp_tao.bean;

public class HeadImage {
    private String headImagePath;

    @Override
    public String toString() {
        return "HeadImage{" +
                "headImagePath='" + headImagePath + '\'' +
                '}';
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }
}
