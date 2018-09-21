package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class DetailsTopic {
    private int comments;
    private String headImagePath;
    private ArrayList<String> imageListThumb;
    private int isFollowed;
    private int isLiked;
    private int isFavoured;
    private int likes;
    private String nickname;
    private String publishTime;
    private String shareLink;
    private String title;
    private String topicId;
    private String userId;

    @Override
    public String toString() {
        return "DetailsTopic{" +
                "comments=" + comments +
                ", headImagePath='" + headImagePath + '\'' +
                ", imageListThumb=" + imageListThumb +
                ", isFollowed=" + isFollowed +
                ", isLiked=" + isLiked +
                ", isFavoured=" + isFavoured +
                ", likes=" + likes +
                ", nickname='" + nickname + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", shareLink='" + shareLink + '\'' +
                ", title='" + title + '\'' +
                ", topicId='" + topicId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
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

    public int getIsFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(int isFollowed) {
        this.isFollowed = isFollowed;
    }

    public int getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(int isLiked) {
        this.isLiked = isLiked;
    }

    public int getIsFavoured() {
        return isFavoured;
    }

    public void setIsFavoured(int isFavoured) {
        this.isFavoured = isFavoured;
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
