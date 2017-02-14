package com.leych.cooking4you.retrofit;

import com.leych.cooking4you.entity.Ingridient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by cher- on 13.02.2017.
 */

public interface IngridientOps {
    @GET("ingrednt/all")
    Call<List<Ingridient>> getAll();
}
