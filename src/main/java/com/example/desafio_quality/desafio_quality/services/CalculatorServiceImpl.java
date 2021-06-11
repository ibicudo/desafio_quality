package com.example.desafio_quality.desafio_quality.services;

import com.example.desafio_quality.desafio_quality.DTOs.HouseAreaDTO;
import com.example.desafio_quality.desafio_quality.models.House;
import com.example.desafio_quality.desafio_quality.models.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public HouseAreaDTO calculateTotalArea(House house) {
        HouseAreaDTO houseAreaDTO = new HouseAreaDTO();
        Double area = 0.0;
        List<Room> listRooms = house.getRooms();

        for(Room room : listRooms){
            area = area + (room.getLength()*room.getWidth());
        }
        houseAreaDTO.setName(house.getName());
        houseAreaDTO.setArea(area);
        return houseAreaDTO;
    }
}
