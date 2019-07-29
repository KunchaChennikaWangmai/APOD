package com.chennikawangmai.chenproject;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Nasaapi {

    @GET("rest/v1/neo/browse?api_key=ooFR0RQAaILFONKCTfvAncp6xYqShL6nHW0RFnr9&")
   // Call<Asteroids>getAsteroids();
    Call<Asteroids>getAsteroids(@Query("page") Integer page);
    @GET("rest/v1/neo/{asteroid_id}")
    Call<SpecificAsteroid>getSpecifiAsteroid(@Path("asteroid_id") Integer id);
    @GET("https://api.nasa.gov/planetary/apod?api_key=ooFR0RQAaILFONKCTfvAncp6xYqShL6nHW0RFnr9&")
    Call<List<apod>>getApod(@QueryMap Map<String,String> parameters);
}
//https://api.nasa.gov/neo/rest/v1/neo/browse?page=1&api_key=DEMO_KEY  https://www.neowsapp.com/rest/v1/neo/browse?api_key=DEMO_KEY&page=15
//Call<List<Crime>>getcrimes(@QueryMap Map<String,Object> parameters);  api_key=ooFR0RQAaILFONKCTfvAncp6xYqShL6nHW0RFnr9