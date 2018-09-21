package com.example.lenovo.mvp_tao.bean;

public class UserProtocol {
    private String userProtocol;
    private String createTime;
    private String id;

    @Override
    public String toString() {
        return "UserProtocol{" +
                "userProtocol='" + userProtocol + '\'' +
                ", createTime='" + createTime + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getUserProtocol() {
        return userProtocol;
    }

    public void setUserProtocol(String userProtocol) {
        this.userProtocol = userProtocol;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
