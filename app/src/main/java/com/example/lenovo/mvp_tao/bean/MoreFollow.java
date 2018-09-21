package com.example.lenovo.mvp_tao.bean;

public class MoreFollow {
    private int followers;
    private String headImagePath;
    private String nickname;
    private String userId;

    @Override
    public String toString() {
        return "MoreFollow{" +
                "followers=" + followers +
                ", headImagePath='" + headImagePath + '\'' +
                ", nickname='" + nickname + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
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
