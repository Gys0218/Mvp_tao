package com.example.lenovo.mvp_tao.bean;

public class newsChannelList {
    private String channelId;
    private String channelName;

    @Override
    public String toString() {
        return "newsChannelList{" +
                "channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                '}';
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
