package com.cedric.simpleweatherapp.Models.FiveDayForecast;

import java.util.HashMap;
import java.util.Map;

public class Temperature {

    private Minimum minimum;
    private Maximum maximum;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Minimum getMinimum() {
        return minimum;
    }

    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }

    public Maximum getMaximum() {
        return maximum;
    }


    public void setMaximum(Maximum maximum) {
        this.maximum = maximum;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

