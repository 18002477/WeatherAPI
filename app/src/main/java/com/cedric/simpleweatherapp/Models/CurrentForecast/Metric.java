package com.cedric.simpleweatherapp.Models.CurrentForecast;

import java.util.HashMap;
import java.util.Map;

public class Metric {

    private Double value;
    private String unit;
    private Integer unitType;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getUnitType() {
        return unitType;
    }

    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
