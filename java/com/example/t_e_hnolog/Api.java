package com.example.t_e_hnolog;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("weather")
    Call<WheaterDetails> getWheaterDetails(@Query("q") String City, @Query("appid") String Appid );
}