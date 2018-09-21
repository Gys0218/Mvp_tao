package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class Comment {
    private ArrayList<userCommentList> userCommentList;

    @Override
    public String toString() {
        return "Comment{" +
                "userCommentList=" + userCommentList +
                '}';
    }

    public ArrayList<com.example.lenovo.mvp_tao.bean.userCommentList> getUserCommentList() {
        return userCommentList;
    }

    public void setUserCommentList(ArrayList<com.example.lenovo.mvp_tao.bean.userCommentList> userCommentList) {
        this.userCommentList = userCommentList;
    }

    public Comment(ArrayList<com.example.lenovo.mvp_tao.bean.userCommentList> userCommentList) {

        this.userCommentList = userCommentList;
    }
}


