package com.example.desafio_quality.desafio_quality.controllers;

import com.example.desafio_quality.desafio_quality.DTOs.HouseAreaDTO;
import com.example.desafio_quality.desafio_quality.DTOs.HousePriceDTO;
import com.example.desafio_quality.desafio_quality.DTOs.RoomAreaDTO;
import com.example.desafio_quality.desafio_quality.models.House;
import com.example.desafio_quality.desafio_quality.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/houses")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @PostMapping("/calculateArea") //US 0001
    public HouseAreaDTO calculateArea (@RequestBody @Valid House house){
        return calculatorService.calculateTotalArea(house);
    }

    @PostMapping("/calculatePrice") //US 0002
    public HousePriceDTO calculatePrice (@RequestBody @Valid House house){
        return calculatorService.calculatePriceHouse(house);
    }

    @PostMapping("/biggesteRoom") //US 0003
    public RoomAreaDTO determineBiggestRoom (@RequestBody @Valid House house){
        return calculatorService.determineTheBiggestRoom(house);
    }

    @PostMapping("/sizeRooms") //US 0004
    public List<RoomAreaDTO> calculateSizeRooms (@RequestBody @Valid House house){
        return calculatorService.calculateSizeRooms(house);
    }

}
