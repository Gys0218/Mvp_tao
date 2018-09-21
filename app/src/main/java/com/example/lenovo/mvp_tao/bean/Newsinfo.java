package com.example.lenovo.mvp_tao.bean;

public class Newsinfo {
    private int comments;
    private String content;
    private int isFavoured;
    private int isLiked;
    private String newsId;
    private String origin;
    private String publishTime;
    private String title;

    @Override
    public String toString() {
        return "Newsinfo{" +
                "comments=" + comments +
                ", content='" + content + '\'' +
                ", isFavoured=" + isFavoured +
                ", isLiked=" + isLiked +
                ", newsId='" + newsId + '\'' +
                ", origin='" + origin + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsFavoured() {
        return isFavoured;
    }

    public void setIsFavoured(int isFavoured) {
        this.isFavoured = isFavoured;
    }

    public int getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(int isLiked) {
        this.isLiked = isLiked;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
