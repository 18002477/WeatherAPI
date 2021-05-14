package com.cedric.simpleweatherapp.Models.CurrentForecast;

import java.util.HashMap;
import java.util.Map;


public class CurrentTemperature {

    private Metric metric;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Metric getMetric() {
        return metric;
    }
    public void setMetric(Metric metric) {
        this.metric = metric;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
