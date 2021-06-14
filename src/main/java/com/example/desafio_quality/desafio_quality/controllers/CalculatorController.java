package com.example.desafio_quality.desafio_quality.controllers;

import com.example.desafio_quality.desafio_quality.DTOs.HouseAreaDTO;
import com.example.desafio_quality.desafio_quality.DTOs.HousePriceDTO;
import com.example.desafio_quality.desafio_quality.DTOs.RoomAreaDTO;
import com.example.desafio_quality.desafio_quality.DTOs.HouseDTO;
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

    @PostMapping("/calculateTotalArea") //US 0001
    public HouseAreaDTO calculateArea (@RequestBody @Valid HouseDTO houseDTO){
        return calculatorService.calculateTotalArea(houseDTO);
    }

    @PostMapping("/calculatePrice") //US 0002
    public HousePriceDTO calculatePrice (@RequestBody @Valid HouseDTO houseDTO){
        return calculatorService.calculatePriceHouse(houseDTO);
    }

    @PostMapping("/biggesteRoom") //US 0003
    public RoomAreaDTO determineBiggestRoom (@RequestBody @Valid HouseDTO houseDTO){
        return calculatorService.determineTheBiggestRoom(houseDTO);
    }

    @PostMapping("/areaRooms") //US 0004
    public List<RoomAreaDTO> calculateAreaRooms (@RequestBody @Valid HouseDTO houseDTO){
        return calculatorService.calculateAreaRooms(houseDTO);
    }

}
