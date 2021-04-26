package com.example.findtheinvestorapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InvestorList {
    @SerializedName("data")
    private List<InvestorModel> data;

    public InvestorList(List<InvestorModel> data) {
        this.data = data;
    }

    public List<InvestorModel> getData() {
        return data;
    }

    public void setData(List<InvestorModel> data) {
        this.data = data;
    }

    public InvestorModel getItemAtIndex(int index){
        return data.get(index);
    }
}
