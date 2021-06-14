package com.example.desafio_quality.desafio_quality.services;

import com.example.desafio_quality.desafio_quality.DTOs.HouseAreaDTO;
import com.example.desafio_quality.desafio_quality.DTOs.HousePriceDTO;
import com.example.desafio_quality.desafio_quality.DTOs.RoomAreaDTO;
import com.example.desafio_quality.desafio_quality.DTOs.HouseDTO;
import com.example.desafio_quality.desafio_quality.models.Room;
import com.example.desafio_quality.desafio_quality.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public HouseAreaDTO calculateTotalArea(HouseDTO houseDTO) {
        HouseAreaDTO houseAreaDTO = new HouseAreaDTO();
        Double area = 0.0;
        List<Room> listRooms = houseDTO.getRooms();

        for(Room room : listRooms){
            area = area + (room.getLength()*room.getWidth());
        }
        houseAreaDTO.setName(houseDTO.getName());
        houseAreaDTO.setArea(area);
        return houseAreaDTO;
    }

    @Override
    public HousePriceDTO calculatePriceHouse(HouseDTO houseDTO) {
        HousePriceDTO housePriceDTO = new HousePriceDTO();
        housePriceDTO.setName(houseDTO.getName());
        housePriceDTO.setDistrict(houseDTO.getDistrict());

        Double priceDistrict = districtRepository.getPriceByDistrict(houseDTO.getDistrict());
        HouseAreaDTO houseAreaDTO = calculateTotalArea(houseDTO);

        Double price = houseAreaDTO.getArea()* priceDistrict;
        housePriceDTO.setPrice(price);

        return housePriceDTO;
    }

    @Override
    public RoomAreaDTO determineTheBiggestRoom(HouseDTO houseDTO) {
        List<Room> listRoom = houseDTO.getRooms();
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
    public List<RoomAreaDTO> calculateAreaRooms (HouseDTO houseDTO) {
        List<Room> listRooms = houseDTO.getRooms();
        RoomAreaDTO roomAreaDTO;
        List<RoomAreaDTO> listRoomsAreaDTO = new ArrayList<>();

        for(Room room: listRooms){
            roomAreaDTO = new RoomAreaDTO();
            roomAreaDTO.setName(room.getName());
            roomAreaDTO.setArea(room.getLength()*room.getWidth());
            listRoomsAreaDTO.add(roomAreaDTO);
        }

        return listRoomsAreaDTO;
    }

}
