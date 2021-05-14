package com.cedric.simpleweatherapp.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cedric.simpleweatherapp.ApiServices.HttpApiService;
import com.cedric.simpleweatherapp.ApiServices.HttpApiServiceClient;
import com.cedric.simpleweatherapp.Models.CurrentForecast.CurrentForecast;
import com.cedric.simpleweatherapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class CurrentFragment extends Fragment {

    HttpApiService httpApiService = HttpApiServiceClient.getHttpApiService();
    View view;
    TextView textView;

    public CurrentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_current, container, false);

        httpApiService.getConditions(httpApiService.key , httpApiService.metric)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new io.reactivex.functions.Consumer<List<CurrentForecast>>() {
                            @Override
                            public void accept(List<CurrentForecast> forecasts) throws Exception {
                                CurrentForecast currentForecast = forecasts.get(0);

                                TextView date = view.findViewById(R.id.textView_Date);
                                date.setText("Today's Date: " + currentForecast.getLocalObservationDateTime().substring(0, 10));

                                ImageView icon = view.findViewById(R.id.imageView_Icon);
                                String iconWithLeading0 = String.format("%02d", currentForecast.getWeatherIcon());
                                String url = "https://developer.accuweather.com/sites/default/files/" + iconWithLeading0 + "-s.png";
                                Picasso
                                        .get()
                                        .load(url)
                                        .into(icon);

                                TextView condition = view.findViewById(R.id.textView_IconPhrase);
                                condition.setText("Current Conditions: " + currentForecast.getWeatherText());

                                TextView min = view.findViewById(R.id.textView_Temp);
                                min.setText("Current Temperature: " + String.valueOf(currentForecast.getTemperature().getMetric().getValue()) + "°C");
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