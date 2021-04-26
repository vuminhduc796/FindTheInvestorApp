package com.example.findtheinvestorapp.model;

import com.example.findtheinvestorapp.model.BusinessItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusinessItemList {
    @SerializedName("data")
    private List<BusinessItem> data;

    public BusinessItemList(List<BusinessItem> data) {
        this.data = data;
    }

    public List<BusinessItem> getItemBuyList() {
        return data;
    }

    public void setItemBuyList(List<BusinessItem> data) {
        this.data = data;
    }
    public BusinessItem getItemAtIndex(int index){
        return data.get(index);
    }
}
