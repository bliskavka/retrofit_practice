package com.example.retrofit_practice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface JsonPlaceholderApi {

    String BASE_URL = "https://api.darksky.net/forecast/";

    @GET("{key}/{latitude},{longitude}")
    Call<WeatherEntity> getPosts(@Path("key") String key,
                                 @Path("latitude") String lat,
                                 @Path("longitude") String lng);
}
