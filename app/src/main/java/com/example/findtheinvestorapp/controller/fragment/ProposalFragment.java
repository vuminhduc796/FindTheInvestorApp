package com.example.findtheinvestorapp.controller.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findtheinvestorapp.controller.BusinessDetailActivity;
import com.example.findtheinvestorapp.R;
import com.example.findtheinvestorapp.controller.adapter.BusinessAdapter;
import com.example.findtheinvestorapp.controller.adapter.ProposalAdapter;
import com.example.findtheinvestorapp.model.BusinessItem;
import com.example.findtheinvestorapp.model.BusinessItemList;
import com.example.findtheinvestorapp.model.ProposalItem;
import com.example.findtheinvestorapp.model.ProposalItemList;
import com.example.findtheinvestorapp.network.JsonApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProposalFragment extends Fragment implements ProposalAdapter.OnItemClickListener {


    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_COMPANY = "companyName";
    public static final String EXTRA_DESC = "desc";

    private RecyclerView mRecyclerView;
    private ProposalAdapter proposalAdapter;
    private ArrayList<ProposalItem> proposalItems;

    public ProposalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_proposal, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        proposalItems = new ArrayList<>();


        proposalAdapter = new ProposalAdapter(getContext(), proposalItems);
        mRecyclerView.setAdapter(proposalAdapter);
        proposalAdapter.setOnItemClickListener(ProposalFragment.this);
        setUpApiCall(view);
        //parseJSON();

        return view;
    }

    protected void setUpApiCall(View root) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://findback.sydneystardigital.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonApi api_call = retrofit.create(JsonApi.class);

        Call<ProposalItemList> call = api_call.getProposalList();
        call.enqueue(new Callback<ProposalItemList>() {
            @Override
            public void onResponse(Call<ProposalItemList> call, Response<ProposalItemList> response) {
                Log.e("nani", response.code() + "");
                if (!response.isSuccessful()) {
                    Log.e("myErrTag", "not successful");

                    return;
                }
                ProposalItemList businessItems = response.body();

                assert businessItems != null;
                for (ProposalItem temp_item : businessItems.getItemBuyList()) {
                    if (temp_item.getProposalTitle() == null) {
                        temp_item.setProposalTitle("N/A");
                    }
                    proposalItems.add(temp_item);
                }
                proposalAdapter.setFullItems(proposalItems);
                proposalAdapter.notifyDataSetChanged();
                Log.e("tagTest", proposalItems.size() + "");
            }


            @Override
            public void onFailure(Call<ProposalItemList> call, Throwable t) {
                Log.e("myErrTag", t.getMessage());
            }
        });
    }


    @Override
    public void onItemClick ( int position ) {
        Intent detailIntent =  new Intent ( getContext (), BusinessDetailActivity.class );
        ProposalItem clickedItem = proposalItems.get ( position );
        detailIntent.putExtra ( "selectedItem", clickedItem);
        startActivity ( detailIntent );
    }
}