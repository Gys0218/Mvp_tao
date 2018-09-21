package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class Searchtopic {
    private String cursor;
    private ArrayList<topicList> topicList;

    @Override
    public String toString() {
        return "Searchtopic{" +
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

class topicList{
    private String comments;
    private String headImagePath;
    private ArrayList<String> imageListThumb;
    private int likes;
    private String nickname;
    private int pageviews;
    private String publishTime;
    private String shareLink;
    private String title;
    private String topicId;
    private String userId;

    @Override
    public String toString() {
        return "topicList{" +
                "comments='" + comments + '\'' +
                ", headImagePath='" + headImagePath + '\'' +
                ", imageListThumb=" + imageListThumb +
                ", likes=" + likes +
                ", nickname='" + nickname + '\'' +
                ", pageviews=" + pageviews +
                ", publishTime='" + publishTime + '\'' +
                ", shareLink='" + shareLink + '\'' +
                ", title='" + title + '\'' +
                ", topicId='" + topicId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPageviews() {
        return pageviews;
    }

    public void setPageviews(int pageviews) {
        this.pageviews = pageviews;
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
