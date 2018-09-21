package com.example.lenovo.mvp_tao.bean;

public class data {
    private String id;
    private String tag;

    @Override
    public String toString() {
        return "data{" +
                "id='" + id + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
