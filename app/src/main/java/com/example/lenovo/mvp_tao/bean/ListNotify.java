package com.example.lenovo.mvp_tao.bean;

public class ListNotify {
    private String fromId;
    private String fromTitle;
    private String fromType;
    private String headImagePath;
    private String nickname;
    private String notifyContent;
    private String notifyContentType;
    private String notifyId;
    private String notifyTime;
    private String notifyTitle;
    private String notifyType;
    private String userId;

    @Override
    public String toString() {
        return "ListNotify{" +
                "fromId='" + fromId + '\'' +
                ", fromTitle='" + fromTitle + '\'' +
                ", fromType='" + fromType + '\'' +
                ", headImagePath='" + headImagePath + '\'' +
                ", nickname='" + nickname + '\'' +
                ", notifyContent='" + notifyContent + '\'' +
                ", notifyContentType='" + notifyContentType + '\'' +
                ", notifyId='" + notifyId + '\'' +
                ", notifyTime='" + notifyTime + '\'' +
                ", notifyTitle='" + notifyTitle + '\'' +
                ", notifyType='" + notifyType + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getFromTitle() {
        return fromTitle;
    }

    public void setFromTitle(String fromTitle) {
        this.fromTitle = fromTitle;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNotifyContent() {
        return notifyContent;
    }

    public void setNotifyContent(String notifyContent) {
        this.notifyContent = notifyContent;
    }

    public String getNotifyContentType() {
        return notifyContentType;
    }

    public void setNotifyContentType(String notifyContentType) {
        this.notifyContentType = notifyContentType;
    }

    public String getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
    }

    public String getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getNotifyTitle() {
        return notifyTitle;
    }

    public void setNotifyTitle(String notifyTitle) {
        this.notifyTitle = notifyTitle;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
