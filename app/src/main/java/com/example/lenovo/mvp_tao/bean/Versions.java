package com.example.lenovo.mvp_tao.bean;

public class Versions {
    private String appUrl;
    private String os;
    private String title;
    private String updateDes;
    private String updateStatus;
    private String updateTime;
    private String updateVersionId;
    private String version;

    @Override
    public String toString() {
        return "Versions{" +
                "appUrl='" + appUrl + '\'' +
                ", os='" + os + '\'' +
                ", title='" + title + '\'' +
                ", updateDes='" + updateDes + '\'' +
                ", updateStatus='" + updateStatus + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateVersionId='" + updateVersionId + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdateDes() {
        return updateDes;
    }

    public void setUpdateDes(String updateDes) {
        this.updateDes = updateDes;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateVersionId() {
        return updateVersionId;
    }

    public void setUpdateVersionId(String updateVersionId) {
        this.updateVersionId = updateVersionId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
