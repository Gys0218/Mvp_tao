package com.example.lenovo.mvp_tao.bean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.ArrayList;
import java.util.List;

public class DownListNews {
    private String cursor;
    private ArrayList<newListt> newList;

    @Override
    public String toString() {
        return "DownListNews{" +
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

    public ArrayList<newListt> getNewList() {
        return newList;
    }

    public void setNewList(ArrayList<newListt> newList) {
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


    public void mergeRefreshData(DownListNews data){

        ArrayList<newListt> newList = data.getNewList();
        if(newList != null && newList.size() > 0){
            if(this.newList == null){
                this.newList = new ArrayList<>();
            }
            this.newList.addAll(0, newList);
        }
    }

    public void mergeLoadMoreData(DownListNews data){
        ArrayList<newListt> newList = data.getNewList();
        if(newList != null && newList.size() > 0){
            if(this.newList == null){
                this.newList = new ArrayList<>();
            }
            this.newList.addAll(newList);

        }

    }


    public void replace(DownListNews data){
        this.setNewList(data.newList);
    }


    public DownListNews getNewsDataForSdcardCache(){

        DownListNews newsData = new DownListNews();

        List<newListt> newsList = new ArrayList<>();

        for(int i = 0; i < Math.min(7, this.newList.size()); i++){
            newsList.add(this.newList.get(i));
        }

        newsData.setNewList(newList);

        return newsData;
    }

}
