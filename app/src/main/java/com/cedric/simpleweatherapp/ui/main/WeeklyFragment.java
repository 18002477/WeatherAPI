package com.cedric.simpleweatherapp.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cedric.simpleweatherapp.ApiServices.HttpApiService;
import com.cedric.simpleweatherapp.ApiServices.HttpApiServiceClient;
import com.cedric.simpleweatherapp.Models.FiveDayForecast.DailyForecast;
import com.cedric.simpleweatherapp.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class WeeklyFragment extends Fragment {

    HttpApiService fiveDayForecastService = HttpApiServiceClient.getHttpApiService();
    View view;

    public WeeklyFragment() {
        // Required empty public constructor
    }
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_weekly, container, false);

//        ForecastUtility fc = new ForecastUtility();
//        fc.execute();
//
//        ArrayList<Forecast> forecasts = fc.ParseJSON();
//
//        ListView forecastListView = view.findViewById(R.id.lvForecast);
//
//        ForecastAdapter forecastAdapter = new ForecastAdapter(getActivity(),0,forecasts);
//        forecastListView.setAdapter(forecastAdapter);

        fiveDayForecastService.getForecasts(fiveDayForecastService.key,fiveDayForecastService.metric)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new io.reactivex.functions.Consumer<DailyForecast>() {
                            @Override
                            public void accept(DailyForecast dailyForecast) throws Exception {
                                List<Forecast> forecasts = dailyForecast.getDailyForecasts();

                                ListView foreCastListView = view.findViewById(R.id.lvForecast);
                                // Check for the code for adapters
                                ForecastAdapter forecastAdapter = new ForecastAdapter(getContext(), 0, (ArrayList<Forecast>) forecasts);
                                foreCastListView.setAdapter(forecastAdapter);
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.i("Error",""+throwable.getMessage());
                            }
                        }

                );

        return view;
    }
}