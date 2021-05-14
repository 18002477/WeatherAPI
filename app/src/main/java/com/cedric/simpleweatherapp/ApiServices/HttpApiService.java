package com.cedric.simpleweatherapp.ApiServices;

import android.location.Location;

import com.cedric.simpleweatherapp.Models.CurrentForecast.CurrentForecast;
import com.cedric.simpleweatherapp.Models.FiveDayForecast.DailyForecast;

import java.util.List;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HttpApiService {
    String key = "188ynxhcnwqGQg8YFNKjKAeLrDQ22FwM";
    String metric ="true";

    @GET("/currentconditions/v1/305605")
    Flowable<List<CurrentForecast>> getConditions(
            @Query("apikey") String key,
            @Query("metric") String metric);

    @GET("/forecasts/v1/daily/5day/305605")
    Flowable<DailyForecast> getForecasts(
            @Query("apikey") String key,
            @Query("metric") String metric);

    @GET("/locations/v1/cities/search")
    Flowable<List<Location>> getCity(
            @Query("apikey") String key,
            @Query("q") String searchQuery);

    @GET("/locations/v1/cities/search")
    Flowable<List<CurrentForecast>> getSpecificConditions(
            @Path("cityCode") String cityCode,
            @Query("apikey") String key,
            @Query("metric") String metric);
}
