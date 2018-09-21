package com.example.lenovo.mvp_tao.bean;

public class AboutUs {
    private String aboutUs;
    private String createTime;
    private String id;

    @Override
    public String toString() {
        return "AboutUs{" +
                "aboutUs='" + aboutUs + '\'' +
                ", createTime='" + createTime + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
