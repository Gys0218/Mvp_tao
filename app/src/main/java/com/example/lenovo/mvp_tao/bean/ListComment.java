package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class ListComment {
    private ArrayList<commentList> commentList;
    private String cursor;

    @Override
    public String toString() {
        return "ListComment{" +
                "commentList=" + commentList +
                ", cursor='" + cursor + '\'' +
                '}';
    }

    public ArrayList<commentList> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<commentList> commentList) {
        this.commentList = commentList;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}

class commentList{
    private String commentTime;
    private String content;
    private String headImagePath;
    private String nickname;
    private String userId;

    @Override
    public String toString() {
        return "commentList{" +
                "commentTime='" + commentTime + '\'' +
                ", content='" + content + '\'' +
                ", headImagePath='" + headImagePath + '\'' +
                ", nickname='" + nickname + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
