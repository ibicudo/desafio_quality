package com.example.desafio_quality.desafio_quality.models;

import java.util.HashMap;
import java.util.Map;

public class District {
    private Map<String, Double> mapDistricts;

    public District() {
        this.mapDistricts = new HashMap<>();
        mapDistricts.put("Presidente Altino", 5000.0);
        mapDistricts.put("Centro", 6000.0);
        mapDistricts.put("Quitauna", 5000.0);
        mapDistricts.put("Ayrosa", 5000.0);
    }

    public Map<String, Double> getMapDistricts() {
        return mapDistricts;
    }

    public void setMapDistricts(Map<String, Double> mapDistricts) {
        this.mapDistricts = mapDistricts;
    }
}
