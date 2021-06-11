package com.example.desafio_quality.desafio_quality.repositories;

import com.example.desafio_quality.desafio_quality.DTOs.HouseAreaDTO;
import com.example.desafio_quality.desafio_quality.models.House;

public interface CalculatorRepository {
    HouseAreaDTO calculateArea (House house);
}
