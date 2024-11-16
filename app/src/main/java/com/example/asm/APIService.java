package com.example.asm;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface APIService {
    String DOMAIN = "http://192.168.0.106:3000/";

    @GET("/api/list")
    Call<List<MotoModel>> getCars();


    @POST("/api/add_body")
    Call<List<MotoModel>> addCar(@Body MotoModel xe);

    @PUT("/api/update_body")
    Call<List<MotoModel>> updateCar(@Body MotoModel xe);

    @DELETE("/api/xoa")
    Call<List<MotoModel>> deleteCar(String id);
}
