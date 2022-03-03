package com.example.exopays.services;

import com.example.exopays.model.Pays;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PaysService {

    @GET(Config.BASE_URL + "pays")
    Call<List<Pays>> getListePays();
}
