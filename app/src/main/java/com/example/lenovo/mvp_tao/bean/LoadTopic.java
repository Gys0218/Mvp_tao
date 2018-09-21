package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class LoadTopic {
    private String cursor;
    private ArrayList<topicList> topicList;

    @Override
    public String toString() {
        return "LoadTopic{" +
                "cursor='" + cursor + '\'' +
                ", topicList=" + topicList +
                '}';
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public ArrayList<topicList> getTopicList() {
        return topicList;
    }

    public void setTopicList(ArrayList<topicList> topicList) {
        this.topicList = topicList;
    }
}
