package com.cedric.simpleweatherapp.Models.CurrentForecast;

import java.util.HashMap;
import java.util.Map;

public class CurrentForecast {


    private String localObservationDateTime;
    private Integer epochTime;
    private String weatherText;
    private Integer weatherIcon;
    private Boolean hasPrecipitation;
    private Object precipitationType;
    private Boolean isDayTime;
    private CurrentTemperature temperature;
    private String mobileLink;
    private String link;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getLocalObservationDateTime() {
        return localObservationDateTime;
    }

    public void setLocalObservationDateTime(String localObservationDateTime) {
        this.localObservationDateTime = localObservationDateTime;
    }

    public Integer getEpochTime() {
        return epochTime;
    }

    public void setEpochTime(Integer epochTime) {
        this.epochTime = epochTime;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public Integer getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(Integer weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public Boolean getHasPrecipitation() {
        return hasPrecipitation;
    }

    public void setHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public Object getPrecipitationType() {
        return precipitationType;
    }

    public void setPrecipitationType(Object precipitationType) {
        this.precipitationType = precipitationType;
    }

    public Boolean getIsDayTime() {
        return isDayTime;
    }

    public void setIsDayTime(Boolean isDayTime) {
        this.isDayTime = isDayTime;
    }


    public CurrentTemperature getTemperature() {
        return temperature;
    }

    public void setTemperature(CurrentTemperature temperature) {
        this.temperature = temperature;
    }

    public String getMobileLink() {
        return mobileLink;
    }

    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    public String getLink() {
        return link;
    }


    public void setLink(String link) {
        this.link = link;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
