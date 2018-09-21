package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class Profession {
    private ArrayList<professionList> professionList;

    @Override
    public String toString() {
        return "Profession{" +
                "professionList=" + professionList +
                '}';
    }

    public ArrayList<professionList> getProfessionList() {
        return professionList;
    }

    public void setProfessionList(ArrayList<professionList> professionList) {
        this.professionList = professionList;
    }
}

class professionList{
   private String professionId;
   private String professionName;

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

    @Override
    public String toString() {
        return "professionList{" +
                "professionId='" + professionId + '\'' +
                ", professionName='" + professionName + '\'' +
                '}';
    }

}
