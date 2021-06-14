package com.example.desafio_quality.desafio_quality.repositories;

import com.example.desafio_quality.desafio_quality.exception.DistrictNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {
    private Map<String, Double> mapDistricts;

    @Override
    public Double getPriceByDistrict(String district) {
        loadDistricts();

        if(!this.mapDistricts.containsKey(district)) {
            throw new DistrictNotFoundException();
        }

        return mapDistricts.get(district);


    }

    private void loadDistricts (){
        this.mapDistricts = new HashMap<>();
        mapDistricts.put("Presidente Altino", 5000.0);
        mapDistricts.put("Centro", 6000.0);
        mapDistricts.put("Quitauna", 5000.0);
        mapDistricts.put("Ayrosa", 5000.0);
        mapDistricts.put("Tupancy", 5000.0);
    }
}
