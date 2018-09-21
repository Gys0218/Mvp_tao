package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class NewsChannel {
    private ArrayList<newsChannelList> newsChannelList;

    @Override
    public String toString() {
        return "NewsChannel{" +
                "newsChannelList=" + newsChannelList +
                '}';
    }

    public ArrayList<newsChannelList> getNewsChannelList() {
        return newsChannelList;
    }

    public void setNewsChannelList(ArrayList<newsChannelList> newsChannelList) {
        this.newsChannelList = newsChannelList;
    }
}

