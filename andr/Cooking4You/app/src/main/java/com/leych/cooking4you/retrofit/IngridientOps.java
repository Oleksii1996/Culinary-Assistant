package com.leych.cooking4you.retrofit;

import com.leych.cooking4you.entity.Ingridient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by cher- on 13.02.2017.
 */

public interface IngridientOps {
    @Headers("Content-Type: application/json")
    @GET("ingredient/all")
    Call<List<Ingridient>> getAll();
}
