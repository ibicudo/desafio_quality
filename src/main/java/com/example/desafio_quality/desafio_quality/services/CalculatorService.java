package com.example.desafio_quality.desafio_quality.services;

import com.example.desafio_quality.desafio_quality.DTOs.HouseAreaDTO;
import com.example.desafio_quality.desafio_quality.models.House;


public interface CalculatorService {
    HouseAreaDTO calculateTotalArea(House house);
}
