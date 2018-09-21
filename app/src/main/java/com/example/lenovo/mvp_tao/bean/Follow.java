package com.example.lenovo.mvp_tao.bean;

public class Follow {
    private String followId;
    private String followTime;
    private String followUid;
    private String headImagePath;
    private String nickname;
    private String personalProfile;

    @Override
    public String toString() {
        return "Follow{" +
                "followId='" + followId + '\'' +
                ", followTime='" + followTime + '\'' +
                ", followUid='" + followUid + '\'' +
                ", headImagePath='" + headImagePath + '\'' +
                ", nickname='" + nickname + '\'' +
                ", personalProfile='" + personalProfile + '\'' +
                '}';
    }

    public String getFollowId() {
        return followId;
    }

    public void setFollowId(String followId) {
        this.followId = followId;
    }

    public String getFollowTime() {
        return followTime;
    }

    public void setFollowTime(String followTime) {
        this.followTime = followTime;
    }

    public String getFollowUid() {
        return followUid;
    }

    public void setFollowUid(String followUid) {
        this.followUid = followUid;
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

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }
}
