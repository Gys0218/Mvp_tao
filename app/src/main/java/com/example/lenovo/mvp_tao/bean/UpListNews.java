package com.example.lenovo.mvp_tao.bean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.ArrayList;
import java.util.List;

public class UpListNews {
    private String maxCursor;
    private String minCursor;
    private int tops;
        private ArrayList<newList> newList;

    @Override
    public String toString() {
        return "UpListNews{" +
                "maxCursor='" + maxCursor + '\'' +
                ", minCursor='" + minCursor + '\'' +
                ", tops=" + tops +
                ", newList=" + newList +
                '}';
    }

    public String getMaxCursor() {
        return maxCursor;
    }

    public void setMaxCursor(String maxCursor) {
        this.maxCursor = maxCursor;
    }

    public String getMinCursor() {
        return minCursor;
    }

    public void setMinCursor(String minCursor) {
        this.minCursor = minCursor;
    }

    public int getTops() {
        return tops;
    }

    public void setTops(int tops) {
        this.tops = tops;
    }

    public ArrayList<newList> getNewList() {
        return newList;
    }

    public void setNewList(ArrayList<newList> newList) {
        this.newList = newList;
    }


    public static class NewsImageConvert implements PropertyConverter<List<String>,String> {


        @Override
        public List<String> convertToEntityProperty(String databaseValue) {
            return null;
        }

        @Override
        public String convertToDatabaseValue(List<String> entityProperty) {
            return null;
        }
    }


    public void mergeRefreshData(UpListNews data){

        ArrayList<newList> newList = data.getNewList();
        if(this.newList != null && this.newList.size() > 0){
            if(this.newList == null){
                this.newList = new ArrayList<>();
            }
            this.newList.addAll(0, newList);
        }
    }

    public void mergeLoadMoreData(UpListNews data){
        ArrayList<newList> newList = data.getNewList();
        if(this.newList != null && this.newList.size() > 0){
            if(this.newList == null){
                this.newList = new ArrayList<>();
            }
            this.newList.addAll(this.newList);

        }

    }


    public void replace(UpListNews data){

        this.setNewList(data.getNewList());
    }


    public UpListNews getNewsDataForSdcardCache(){

        UpListNews newsData = new UpListNews();

        List<newList> newsList = new ArrayList<>();

        for(int i = 0; i < Math.min(7, this.newList.size()); i++){
            newsList.add(this.newList.get(i));
        }

        newsData.setNewList(newList);

        return newsData;
    }
}

