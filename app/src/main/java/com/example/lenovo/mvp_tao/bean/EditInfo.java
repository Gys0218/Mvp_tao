package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class EditInfo {
    private ArrayList<String> imageListThumb;
    private String shareLink;
    private ArrayList<String> tagList;
    private String title;
    private String topicId;

    @Override
    public String toString() {
        return "EditInfo{" +
                "imageListThumb=" + imageListThumb +
                ", shareLink='" + shareLink + '\'' +
                ", tagList=" + tagList +
                ", title='" + title + '\'' +
                ", topicId='" + topicId + '\'' +
                '}';
    }

    public ArrayList<String> getImageListThumb() {
        return imageListThumb;
    }

    public void setImageListThumb(ArrayList<String> imageListThumb) {
        this.imageListThumb = imageListThumb;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public ArrayList<String> getTagList() {
        return tagList;
    }

    public void setTagList(ArrayList<String> tagList) {
        this.tagList = tagList;
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
}
