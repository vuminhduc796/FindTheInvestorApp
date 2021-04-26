package com.example.findtheinvestorapp.controller.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.findtheinvestorapp.R;
import com.example.findtheinvestorapp.model.BusinessItem;
import com.example.findtheinvestorapp.model.BusinessItemList;
import com.example.findtheinvestorapp.model.InvestorList;
import com.example.findtheinvestorapp.model.InvestorModel;
import com.example.findtheinvestorapp.network.APIclient;
import com.example.findtheinvestorapp.network.JsonApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class InvestorFragment extends Fragment {

    private GridView gridView;

    private CustomAdapter customAdapter;
    private ArrayList <InvestorModel> investorModelArrayList;

    public InvestorFragment ( ) {
        // Required empty public constructor
    }

    @Override
    public View onCreateView ( LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
         View v = inflater.inflate ( R.layout.fragment_investor, container, false );
         investorModelArrayList = new ArrayList<>();
         gridView = v.findViewById ( R.id.gridView);
         customAdapter = new CustomAdapter (investorModelArrayList,getContext());
         gridView.setAdapter ( customAdapter );


        //network call
        //Call <InvestorList> call = APIclient.apIinterface ().getInvestorList ();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://findback.sydneystardigital.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonApi jsonBuyApi = retrofit.create(JsonApi.class);

        Call<InvestorList> call = jsonBuyApi.getInvestorList();
        call.enqueue ( new Callback < InvestorList > ( ) {
            @Override
            public void onResponse ( Call < InvestorList > call, Response < InvestorList > response ) {


                if (!response.isSuccessful()) {
                        Log.e("myErrTag", "not successful");

                        return;
                    }
                    InvestorList investors = response.body();

                    assert investors != null;
                    for (InvestorModel temp_item : investors.getData()) {
                        if(temp_item.getMainImage() == null) {
                            temp_item.setMainImage("uploads/businesslogo/221b294e-e433-4f04-be9a-e8c198c68065.png");
                        }
                        if(temp_item.getCompanyName() == null) {
                            temp_item.setCompanyName("N/A");
                        }
                        String imageUrl = ("https://findback.sydneystardigital.com/" + temp_item.getMainImage());
                        temp_item.setMainImage(imageUrl);
                        investorModelArrayList.add(temp_item);


                    }
                    customAdapter.setFullItems(investorModelArrayList);
                    customAdapter.notifyDataSetChanged();
                }
            @Override
            public void onFailure ( Call <InvestorList > call, Throwable t ) {
                Toast.makeText ( getContext (),"An error Occurred" + t.getLocalizedMessage (), Toast.LENGTH_LONG ).show ();

            }
        } );


        return v;





    }

    public class CustomAdapter extends BaseAdapter{

        public List < InvestorModel > investorList;
        public Context context;
        private ArrayList<InvestorModel> full_items;
        public CustomAdapter ( List < InvestorModel > investorLists, Context newcontext ) {
            investorList = investorLists;
            context = newcontext;
            full_items = new ArrayList<>(investorList);
        }

        public void setFullItems(ArrayList<InvestorModel> items){
            if(full_items.size() < items.size()) {
                this.full_items = new ArrayList<InvestorModel>(items);
            }
        }
        @Override
        public int getCount ( ) {
            return investorList.size ();
        }

        @Override
        public Object getItem ( int position ) {
            return null;
        }

        @Override
        public long getItemId ( int position ) {
            return position;
        }

        @Override
        public View getView ( int position, View convertView, ViewGroup parent ) {
            View view = LayoutInflater.from ( context ).inflate ( R.layout.row_invst_data, null );

            //find view
            TextView name = view.findViewById ( R.id.textView );
            ImageView imageView = view.findViewById ( R.id.IvimageView );

            //set data
            name.setText ( investorList.get(position).getCompanyName() );



            //set Image
            Glide.with(context)
                    .load(investorList.get(position).getMainImage ())
                    .into(imageView);

            return view;
        }
    }



    /*
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


     */


    @Override
    public void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );

    }
}
