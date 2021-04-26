package com.example.findtheinvestorapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.findtheinvestorapp.model.BusinessItem;
import com.example.findtheinvestorapp.model.BusinessItemList;
import com.example.findtheinvestorapp.network.JsonApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BusinessFragment extends Fragment implements BusinessAdapter.OnItemClickListener {


    public  static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_COMPANY = "companyName";
    public static final String EXTRA_DESC = "desc";

    private RecyclerView mRecyclerView;
    private BusinessAdapter mBusinessAdapter;
    private ArrayList <BusinessItem> mBusinessList;

    public BusinessFragment ( ) {
        // Required empty public constructor
    }


    @Override
    public View onCreateView ( LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate ( R.layout.fragment_business, container, false );
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager (getContext()));
        mBusinessList = new ArrayList<>();


        mBusinessAdapter = new BusinessAdapter ( getContext (),mBusinessList );
        mRecyclerView.setAdapter ( mBusinessAdapter );
        mBusinessAdapter.setOnItemClickListener ( BusinessFragment.this );
        setUpApiCall(view);
        //parseJSON();

        return  view;
    }
    protected void setUpApiCall(View root) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://findback.sydneystardigital.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonApi jsonBuyApi = retrofit.create(JsonApi.class);

        Call<BusinessItemList> call = jsonBuyApi.getBusinessItems();
        call.enqueue(new Callback<BusinessItemList>() {
            @Override
            public void onResponse(Call<BusinessItemList> call, Response<BusinessItemList> response) {
                Log.e("nani", response.code()+ "");
                if (!response.isSuccessful()) {
                    Log.e("myErrTag", "not successful");

                    return;
                }
                BusinessItemList businessItems = response.body();

                assert businessItems != null;
                for (BusinessItem temp_item : businessItems.getItemBuyList()) {
                    if(temp_item.getMainImage() == null) {
                        temp_item.setMainImage("uploads/businesslogo/221b294e-e433-4f04-be9a-e8c198c68065.png");
                    }
                    if(temp_item.getCompanyName() == null) {
                            temp_item.setCompanyName("N/A");
                    }
                        String imageUrl = ("https://findback.sydneystardigital.com/" + temp_item.getMainImage());
                        temp_item.setMainImage(imageUrl);
                    mBusinessList.add(temp_item);


                }
                mBusinessAdapter.setFullItems(mBusinessList);
                mBusinessAdapter.notifyDataSetChanged();
                Log.e("tagTest",mBusinessList.size() + "");
            }


            @Override
            public void onFailure(Call<BusinessItemList> call, Throwable t) {
                Log.e("myErrTag", t.getMessage());
            }
        });
    }
    /*private void parseJSON(){
     String url = "https://findback.sydneystardigital.com/businessprofile/getAllBusinessProfiles";
       //String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";


        JsonObjectRequest request = new JsonObjectRequest ( Request.Method.GET, url, null,
                new Response.Listener < JSONObject > ( ) {
                    @Override
                    public void onResponse ( JSONObject response ) {
                        try {
                           // String s = "https://findback.sydneystardigital.com/";
                           JSONArray jsonArray = response.getJSONArray ( "data" );
                            //JSONArray jsonArray = response.getJSONArray ( "hits" );

                            for (int i = 0 ; i< jsonArray.length (); i++) {
                                //for (int i = 0 ; i< 3; i++){
                                JSONObject hits = jsonArray.getJSONObject ( i );
                                String companyName;
                                if ( hits.has ( "companyName" ) ) {
                                    companyName = hits.getString ( "companyName" );
                                } else {
                                    companyName = "N/A";

                                }
                                //String companyName = hits.getString ( "user" );

                                //Log.d("test",hits.getString ( "companyName" )); Test case
                                String imageUrl;
                                if ( hits.has( "mainImage" )  ) {
                                    imageUrl = "https://findback.sydneystardigital.com/".concat ( hits.getString ( "mainImage" ) );
                                } else {
                                    imageUrl = "https://findback.sydneystardigital.com/".concat ( "uploads/businesslogo/221b294e-e433-4f04-be9a-e8c198c68065.png" );
                                }

                                //String imageUrl =  hits.getString ( "webformatURL" );
                                String desc;
                                if ( hits.has ( "productsAndServices" ) ) {
                                    desc = hits.getString ( "productsAndServices" );
                                } else {
                                    desc = " fixed description";
                                }

                                //String desc = hits.getString ( "type" );

                                mBusinessList.add ( new BusinessItem ( imageUrl, companyName, desc ) );
                            }
                              //  Log.d("test",hits.getString ( "productsAndServices" ));

    *//*
                            mBusinessAdapter = new BusinessAdapter ( getContext (),mBusinessList );
                            mRecyclerView.setAdapter ( mBusinessAdapter );
                             mBusinessAdapter.setOnItemClickListener ( BusinessFragment.this );

     *//*
                                mBusinessAdapter.notifyDataSetChanged ();


                        } catch (JSONException e) {
                            e.printStackTrace ( );
                        }

                    }
                }, new Response.ErrorListener ( ) {
            @Override
            public void onErrorResponse ( VolleyError error ) {
                error.printStackTrace ();
            }
        } );
        mRequestQueue.add ( request );
    }*/

    //@Override
    //public void onCreate ( Bundle savedInstanceState ) {
     //   super.onCreate ( savedInstanceState );
   // }



    @Override
    public void onItemClick ( int position ) {
        Intent detailIntent =  new Intent ( getContext (), BusinessDetailActivity.class );
        BusinessItem clickedItem = mBusinessList.get ( position );
        detailIntent.putExtra ( "selectedItem", clickedItem);
       startActivity ( detailIntent );
    }
    }
