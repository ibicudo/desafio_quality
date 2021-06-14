package com.example.desafio_quality.desafio_quality.services;

import com.example.desafio_quality.desafio_quality.DTOs.HouseAreaDTO;
import com.example.desafio_quality.desafio_quality.DTOs.HousePriceDTO;
import com.example.desafio_quality.desafio_quality.DTOs.RoomAreaDTO;
import com.example.desafio_quality.desafio_quality.DTOs.HouseDTO;

import java.util.List;


public interface CalculatorService {
    HouseAreaDTO calculateTotalArea(HouseDTO houseDTO);
    HousePriceDTO calculatePriceHouse (HouseDTO houseDTO);
    RoomAreaDTO determineTheBiggestRoom (HouseDTO houseDTO);
    List<RoomAreaDTO> calculateAreaRooms (HouseDTO houseDTO);
}
