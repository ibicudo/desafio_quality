package com.example.desafio_quality.desafio_quality.services;

import com.example.desafio_quality.desafio_quality.DTOs.HouseAreaDTO;
import com.example.desafio_quality.desafio_quality.DTOs.HousePriceDTO;
import com.example.desafio_quality.desafio_quality.DTOs.RoomAreaDTO;
import com.example.desafio_quality.desafio_quality.models.House;

import java.util.List;


public interface CalculatorService {
    HouseAreaDTO calculateTotalArea(House house);
    RoomAreaDTO determineTheBiggestRoom (House house);
    List<RoomAreaDTO> calculateSizeRooms (House house);
    HousePriceDTO calculatePriceHouse (House house);
}
