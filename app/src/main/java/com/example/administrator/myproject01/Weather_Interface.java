package com.example.administrator.myproject01;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Weather_Interface {

    @Headers({"Accept: application/json","appKey:4d6e5f92-cd69-397f-a9c3-c7f0848506e0"})
    @GET("weather/forecast/6days")
    Call<WeatherRepo> repoContributors(@Query("version") int version, @Query("lat") double lat, @Query("lon") double lon);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://apis.skplanetx.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
