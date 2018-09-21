package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class Topic {
    private String cursor;
    private ArrayList<favouritTopicList> favouritTopicList;

    @Override
    public String toString() {
        return "Topic{" +
                "cursor='" + cursor + '\'' +
                ", favouritTopicList=" + favouritTopicList +
                '}';
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public ArrayList<favouritTopicList> getFavouritTopicList() {
        return favouritTopicList;
    }

    public void setFavouritTopicList(ArrayList<favouritTopicList> favouritTopicList) {
        this.favouritTopicList = favouritTopicList;
    }
}

class favouritTopicList{
    private String favouritId;
    private String comment;
    private String headImagePath;
    private ArrayList<String> imageListThumb;
    private String nickname;
    private String publishTime;
    private String shareLink;
    private String title;
    private String topicId;
    private String userId;

    @Override
    public String toString() {
        return "favouritTopicList{" +
                "favouritId='" + favouritId + '\'' +
                ", comment='" + comment + '\'' +
                ", headImagePath='" + headImagePath + '\'' +
                ", imageListThumb=" + imageListThumb +
                ", nickname='" + nickname + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", shareLink='" + shareLink + '\'' +
                ", title='" + title + '\'' +
                ", topicId='" + topicId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getFavouritId() {
        return favouritId;
    }

    public void setFavouritId(String favouritId) {
        this.favouritId = favouritId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }

    public ArrayList<String> getImageListThumb() {
        return imageListThumb;
    }

    public void setImageListThumb(ArrayList<String> imageListThumb) {
        this.imageListThumb = imageListThumb;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

