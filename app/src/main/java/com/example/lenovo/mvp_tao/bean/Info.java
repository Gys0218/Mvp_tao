package com.example.lenovo.mvp_tao.bean;

public class Info {
    private String birthday;
    private String headImagePath;
    private String nickname;
    private String personalProfile;
    private String phone;
    private String professionId;
    private String professionName;
    private String sex;
    private String userId;

    @Override
    public String toString() {
        return "Info{" +
                "birthday='" + birthday + '\'' +
                ", headImagePath='" + headImagePath + '\'' +
                ", nickname='" + nickname + '\'' +
                ", personalProfile='" + personalProfile + '\'' +
                ", phone='" + phone + '\'' +
                ", professionId='" + professionId + '\'' +
                ", professionName='" + professionName + '\'' +
                ", sex='" + sex + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
