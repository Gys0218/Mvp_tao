package com.example.lenovo.mvp_tao.bean;

public class News {
    private String favouritId;
    private String newsId;
    private String title;

    @Override
    public String toString() {
        return "News{" +
                "favouritId='" + favouritId + '\'' +
                ", newsId='" + newsId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getFavouritId() {
        return favouritId;
    }

    public void setFavouritId(String favouritId) {
        this.favouritId = favouritId;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
