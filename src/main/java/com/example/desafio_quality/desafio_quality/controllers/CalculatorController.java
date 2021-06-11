package com.example.desafio_quality.desafio_quality.controllers;

import com.example.desafio_quality.desafio_quality.DTOs.HouseAreaDTO;
import com.example.desafio_quality.desafio_quality.models.House;
import com.example.desafio_quality.desafio_quality.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/houses")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @PostMapping("/calculateArea")
    public HouseAreaDTO calculateArea (@RequestBody @Valid House house){
        return calculatorService.calculateTotalArea(house);
    }

}
