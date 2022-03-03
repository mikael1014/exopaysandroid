package com.example.exopays.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {
    //machine physique : http://10.0.2.2:8080/api  ou http://votre_ip:8080/api
    public static final String BASE_URL = "http://10.0.2.2:8080/api/";
//    public static final String API_KEY ="6d8512c0f6ba85d4aac70af47ba74b1c";
    public static Retrofit retrofit= null;

    public static Retrofit getApiClient(){
        if (retrofit == null) {
            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
