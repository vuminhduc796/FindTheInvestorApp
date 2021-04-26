package com.example.findtheinvestorapp.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProposalItemList {
    @SerializedName("data")
    private List<ProposalItem> data;

    public ProposalItemList(List<ProposalItem> data) {
        this.data = data;
    }

    public List<ProposalItem> getItemBuyList() {
        return data;
    }

    public void setItemBuyList(List<ProposalItem> data) {
        this.data = data;
    }
    public ProposalItem getItemAtIndex(int index){
        return data.get(index);
    }
}