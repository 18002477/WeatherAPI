package com.cedric.simpleweatherapp.Models.FiveDayForecast;

import java.util.HashMap;
import java.util.Map;

public class Day {

    private Integer icon;

    private String iconPhrase;

    private Boolean hasPrecipitation;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Integer getIcon() {
        return icon;
    }


    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }


    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }


    public Boolean getHasPrecipitation() {
        return hasPrecipitation;
    }


    public void setHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

