package com.cedric.simpleweatherapp.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cedric.simpleweatherapp.ApiServices.HttpApiService;
import com.cedric.simpleweatherapp.ApiServices.HttpApiServiceClient;
import com.cedric.simpleweatherapp.MainActivity;
import com.cedric.simpleweatherapp.Models.CurrentForecast.CurrentForecast;

import com.cedric.simpleweatherapp.R;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Suppress;
import com.cedric.simpleweatherapp.Models.Location.Location;



public class SearchFragment extends Fragment {

    HttpApiService httpApiService = HttpApiServiceClient.getHttpApiService();
    View view;
    TextView localName,date,condition,temp;
    ImageView icon;

    String locationID,searchQuery,localisedName;

    private MaterialSearchBar materialSearchBar;


    public SearchFragment() {
        // Required empty public constructor
    }

//    @SuppressLint("CheckResult")
//    private void getCityCode(){
//        httpApiService.getCity(httpApiService.key,searchQuery)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        new Consumer<List<Location>>() {
//                            @Override
//                            public void accept(List<Location> locations) throws Exception {
//                                Location location = locations.get(0);
//                                locationID = location.getKey();
//                                localisedName = location.getLocalizedName();
//
//                                Log.i("LocatinID",""+locationID);
//
//                                getCurrentConditions();
//                            }
//                        },
//                            new Consumer<Throwable>() {
//                            @Override
//                            public void accept(Throwable throwable) throws Exception {
//                                Log.i("Error",""+throwable.getMessage());
//                                TextView localName = view.findViewById(R.id.textView_localisedName);
//                                localName.setText("No City Found");
//                            }
//                        }
//                );
//    }

    @SuppressLint("CheckResult")
    private void getCurrentConditions(){
        httpApiService.getSpecificConditions(locationID, httpApiService.key, httpApiService.metric)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<List<CurrentForecast>>() {
                            @Override
                            public void accept(List<CurrentForecast> forecasts) throws Exception {
                                CurrentForecast currentForecast = forecasts.get(0);

                                localName = view.findViewById(R.id.textView_localisedName);
                                localName.setText("Location: " + localName);

                                date = view.findViewById(R.id.textView_Date);
                                date.setText("Today's date: " + currentForecast.getLocalObservationDateTime().substring(0, 10));

                                icon = view.findViewById(R.id.imageView_Icon);
                                String iconWithLeading0 = String.format("%02d", currentForecast.getWeatherIcon());
                                String url = "https://developer.accuweather.com/sites/default/files/" + iconWithLeading0 + "-s.png";
                                Picasso
                                        .get()
                                        .load(url)
                                        .into(icon);

                                condition = view.findViewById(R.id.textView_IconPhrase);
                                condition.setText("Current Conditions: " + currentForecast.getWeatherText());

                                temp = view.findViewById(R.id.textView_Temp);
                                temp.setText("Current Temperature: " + String.valueOf(currentForecast.getTemperature().getMetric().getValue()) + "°C");
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.i("Error",""+throwable.getMessage());
                            }
                        }
                );
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       view = inflater.inflate(R.layout.fragment_search, container, false);

        materialSearchBar = view.findViewById(R.id.searchBar);

        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {

            }

            @Override
            public void onSearchConfirmed(CharSequence text) {

            }

            @Override
            public void onButtonClicked(int buttonCode) {
                if (buttonCode == MaterialSearchBar.BUTTON_NAVIGATION)
                {
                    // OPENING OR CLOSING A DRAWER LAYOUT

                }else if (buttonCode == MaterialSearchBar.BUTTON_BACK)
                {
                    materialSearchBar.disableSearch();
                }
            }
        });

        return view;
    }


}