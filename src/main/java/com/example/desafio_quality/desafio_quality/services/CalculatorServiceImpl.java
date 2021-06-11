package com.example.desafio_quality.desafio_quality.services;

import com.example.desafio_quality.desafio_quality.DTOs.HouseAreaDTO;
import com.example.desafio_quality.desafio_quality.DTOs.HousePriceDTO;
import com.example.desafio_quality.desafio_quality.DTOs.RoomAreaDTO;
import com.example.desafio_quality.desafio_quality.models.House;
import com.example.desafio_quality.desafio_quality.models.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public RoomAreaDTO determineTheBiggestRoom(House house) {
        List<Room> listRoom = house.getRooms();
        List<Double> areaRoom = new ArrayList<>();
        RoomAreaDTO roomAreaDTO = new RoomAreaDTO();

        for(Room room: listRoom){
            areaRoom.add(room.getWidth()*room.getLength());
        }
        Double area = Collections.max(areaRoom);
        int index = areaRoom.indexOf(area);

        roomAreaDTO.setName(listRoom.get(index).getName()) ;
        roomAreaDTO.setArea(area);

        return roomAreaDTO;
    }

    @Override
    public List<RoomAreaDTO> calculateSizeRooms (House house) {
        List<Room> listRooms = house.getRooms();
        RoomAreaDTO roomAreaDTO;
        List<RoomAreaDTO> listRoomsSizeDTO = new ArrayList<>();

        for(Room room: listRooms){
            roomAreaDTO = new RoomAreaDTO();
            roomAreaDTO.setName(room.getName());
            roomAreaDTO.setArea(room.getLength()*room.getWidth());
            listRoomsSizeDTO.add(roomAreaDTO);
        }

        return listRoomsSizeDTO;
    }

    @Override
    public HousePriceDTO calculatePriceHouse(House house) {
        HousePriceDTO housePriceDTO = new HousePriceDTO();
        housePriceDTO.setName(house.getName());
        housePriceDTO.setDistrict(house.getDistrict());

        house.setValueByDistricts(house.getDistrict());
        HouseAreaDTO houseAreaDTO = calculateTotalArea(house);

        Double price = houseAreaDTO.getArea()*house.getValueByDistricts();
        housePriceDTO.setPrice(price);

        return housePriceDTO;
    }


}
