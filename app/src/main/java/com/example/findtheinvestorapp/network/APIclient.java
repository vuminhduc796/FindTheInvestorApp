package com.example.findtheinvestorapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIclient {

    //url
    public static String url = "http://findback.sydneystardigital.com/";

    //retrofit

    public  static Retrofit getClient(){

        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( url )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();

        return retrofit;
    }

    public static JsonApi apIinterface(){
        return getClient ().create ( JsonApi.class);
    }
}
