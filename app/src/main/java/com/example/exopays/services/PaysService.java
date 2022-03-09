package com.example.exopays.services;

import com.example.exopays.model.Pays;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PaysService {

    @GET(Config.BASE_URL + "pays")
    Call<List<Pays>> getListePays();

    @GET(Config.BASE_URL+"pays/{id}")
    Call<Pays> getPaysById(@Path(value = "id") long idPays);

    @POST(Config.BASE_URL + "pays")
    Call<Pays> savePays(@Body Pays pays);

}
