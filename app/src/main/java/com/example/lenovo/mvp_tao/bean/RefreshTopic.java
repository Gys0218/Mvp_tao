package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class RefreshTopic {
    private String maxCursor;
    private String minCursor;
    private ArrayList<topicList> topicList;

    @Override
    public String toString() {
        return "RefreshTopic{" +
                "maxCursor='" + maxCursor + '\'' +
                ", minCursor='" + minCursor + '\'' +
                ", topicList=" + topicList +
                '}';
    }

    public String getMaxCursor() {
        return maxCursor;
    }

    public void setMaxCursor(String maxCursor) {
        this.maxCursor = maxCursor;
    }

    public String getMinCursor() {
        return minCursor;
    }

    public void setMinCursor(String minCursor) {
        this.minCursor = minCursor;
    }

    public ArrayList<topicList> getTopicList() {
        return topicList;
    }

    public void setTopicList(ArrayList<topicList> topicList) {
        this.topicList = topicList;
    }
}
