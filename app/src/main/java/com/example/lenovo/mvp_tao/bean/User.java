package com.example.lenovo.mvp_tao.bean;

public class User {

    private int comments;
    private int favorites;
    private int following;
    private int historyReads;
    private int isWifiImages;
    private String nickname;
    private String personalProfile;
    private String headImagePath;
    private String phone;
    private int unMessages;

    @Override
    public String toString() {
        return "User{" +
                "comments=" + comments +
                ", favorites=" + favorites +
                ", following=" + following +
                ", historyReads=" + historyReads +
                ", isWifiImages=" + isWifiImages +
                ", nickname='" + nickname + '\'' +
                ", personalProfile='" + personalProfile + '\'' +
                ", headImagePath='" + headImagePath + '\'' +
                ", phone='" + phone + '\'' +
                ", unMessages=" + unMessages +
                '}';
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getHistoryReads() {
        return historyReads;
    }

    public void setHistoryReads(int historyReads) {
        this.historyReads = historyReads;
    }

    public int getIsWifiImages() {
        return isWifiImages;
    }

    public void setIsWifiImages(int isWifiImages) {
        this.isWifiImages = isWifiImages;
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

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUnMessages() {
        return unMessages;
    }

    public void setUnMessages(int unMessages) {
        this.unMessages = unMessages;
    }
}
