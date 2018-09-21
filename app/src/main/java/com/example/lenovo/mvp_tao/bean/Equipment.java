package com.example.lenovo.mvp_tao.bean;

public class Equipment {

    private String deviceId;

    @Override
    public String toString() {
        return "Equipment{" +
                "deviceId='" + deviceId + '\'' +
                '}';
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
