package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class Newssearch {
    private String cursor;
    private ArrayList<newList> newList;

    @Override
    public String toString() {
        return "Newssearch{" +
                "cursor='" + cursor + '\'' +
                ", newList=" + newList +
                '}';
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public ArrayList<newList> getNewList() {
        return newList;
    }

    public void setNewList(ArrayList<newList> newList) {
        this.newList = newList;
    }
}
