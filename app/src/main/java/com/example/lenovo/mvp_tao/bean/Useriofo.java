package com.example.lenovo.mvp_tao.bean;

public class Useriofo {
    private int followers;
    private String headImagePath;
    private int isFollowed;
    private String nickname;
    private String personalProfile;
    private int topics;
    private String userId;

    @Override
    public String toString() {
        return "Useriofo{" +
                "followers=" + followers +
                ", headImagePath='" + headImagePath + '\'' +
                ", isFollowed=" + isFollowed +
                ", nickname='" + nickname + '\'' +
                ", personalProfile='" + personalProfile + '\'' +
                ", topics=" + topics +
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

    public int getIsFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(int isFollowed) {
        this.isFollowed = isFollowed;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public int getTopics() {
        return topics;
    }

    public void setTopics(int topics) {
        this.topics = topics;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
