package com.example.findtheinvestorapp.network;

import com.example.findtheinvestorapp.model.BusinessItemList;
import com.example.findtheinvestorapp.model.InvestorList;
import com.example.findtheinvestorapp.model.ProposalItemList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {
    @GET("businessprofile/getAllBusinessProfiles")
    Call<BusinessItemList> getBusinessItems();

    @GET("investorprofile/getAllInvestorProfiles")
    Call <InvestorList> getInvestorList();

    @GET("proposal/getAllProposals")
    Call <ProposalItemList> getProposalList();

}
