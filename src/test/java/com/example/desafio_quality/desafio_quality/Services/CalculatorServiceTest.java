package com.example.desafio_quality.desafio_quality.Services;

import com.example.desafio_quality.desafio_quality.DTOs.HouseAreaDTO;
import com.example.desafio_quality.desafio_quality.DTOs.HousePriceDTO;
import com.example.desafio_quality.desafio_quality.DTOs.RoomAreaDTO;
import com.example.desafio_quality.desafio_quality.DTOs.HouseDTO;
import com.example.desafio_quality.desafio_quality.exception.DistrictNotFoundException;
import com.example.desafio_quality.desafio_quality.models.Room;
import com.example.desafio_quality.desafio_quality.repositories.DistrictRepository;
import com.example.desafio_quality.desafio_quality.services.CalculatorService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.DigestException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class CalculatorServiceTest {


    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private DistrictRepository districtRepository;

    HouseDTO houseDTO;

    @BeforeEach
    public void setUp (){
        this.houseDTO = new HouseDTO();
        List<Room> listRooms = new ArrayList<>();
        Room roomA = new Room();
        roomA.setName("Quarto");
        roomA.setLength(4.0);
        roomA.setWidth(4.0);
        listRooms.add(roomA);

        Room roomB = new Room();
        roomB.setName("Sala");
        roomB.setLength(5.0);
        roomB.setWidth(4.0);
        listRooms.add(roomB);

        Room roomC = new Room();
        roomC.setName("Cozinha");
        roomC.setLength(3.0);
        roomC.setWidth(4.0);
        listRooms.add(roomC);


        houseDTO.setName("Apartamento em Barueri");
        houseDTO.setDistrict("Tupancy");
        houseDTO.setRooms(listRooms);
    }

    @Test
    void shouldCalculateRightTotalArea() throws Exception{
        //Arrange
        HouseAreaDTO houseAreaExpeted = new HouseAreaDTO();
        houseAreaExpeted.setArea(48.0);
        houseAreaExpeted.setName("Apartamento em Barueri");

        //act
        HouseAreaDTO houseAreaCalculated = calculatorService.calculateTotalArea(this.houseDTO);

        //Assert
        Assertions.assertEquals(houseAreaExpeted.getArea() , houseAreaCalculated.getArea());

    }

    @Test
    void shouldCalculateWrongTotalArea() throws Exception{
        //Arrange
        HouseAreaDTO houseAreaExpeted = new HouseAreaDTO();
        houseAreaExpeted.setArea(45.0);
        houseAreaExpeted.setName("Apartamento em Barueri");

        //act
        HouseAreaDTO houseAreaCalculated = calculatorService.calculateTotalArea(this.houseDTO);

        //Assert
        Assertions.assertNotEquals(houseAreaExpeted.getArea() , houseAreaCalculated.getArea());

    }

    @Test
    void shouldCalculateRightPrice (){
        //Arrange
        HousePriceDTO housePriceDTOExpected = new HousePriceDTO();
        housePriceDTOExpected.setPrice(240000.0);
        housePriceDTOExpected.setName("Apartamento em Barueri");
        housePriceDTOExpected.setDistrict("Tupancy");

        //act
        HousePriceDTO housePriceDTOCalculated = calculatorService.calculatePriceHouse(this.houseDTO);

        //Assert
        Assertions.assertEquals(housePriceDTOExpected.getPrice(), housePriceDTOCalculated.getPrice());
        Assertions.assertEquals(housePriceDTOExpected.getDistrict(), housePriceDTOCalculated.getDistrict());

    }


    @Test
    void shouldCalculatePriceDistrictDoesNotExist (){


        this.houseDTO.setDistrict("Jardim de Abril");

        assertThrows(DistrictNotFoundException.class, () -> {
            HousePriceDTO housePriceDTOCalculated = calculatorService.calculatePriceHouse(this.houseDTO);
        });

    }

    @Test
    void shouldCalculateWrongPrice (){
        //Arrange
        HousePriceDTO housePriceDTOExpected = new HousePriceDTO();
        housePriceDTOExpected.setPrice(288000.0);
        housePriceDTOExpected.setName("Apartamento em Osasco");
        housePriceDTOExpected.setDistrict("Centro");

        //act
        HousePriceDTO housePriceDTOCalculated = calculatorService.calculatePriceHouse(this.houseDTO);

        //Assert
        Assertions.assertNotEquals(housePriceDTOExpected.getPrice(), housePriceDTOCalculated.getPrice());
        Assertions.assertNotEquals(housePriceDTOExpected.getDistrict(), housePriceDTOCalculated.getDistrict());

    }


    @Test
    void shouldDetermineRightBiggestRoom() {
        //Arrange
        RoomAreaDTO roomAreaDTOExpected = new RoomAreaDTO();
        roomAreaDTOExpected.setArea(20.0);
        roomAreaDTOExpected.setName("Sala");

        //act
        RoomAreaDTO roomAreaDTOCalculated = calculatorService.determineTheBiggestRoom(this.houseDTO);

        //Assert
        Assertions.assertEquals(roomAreaDTOExpected.getName(), roomAreaDTOCalculated.getName());
        Assertions.assertEquals(roomAreaDTOExpected.getArea(), roomAreaDTOCalculated.getArea());
    }

    @Test
    void shouldDetermineWrongBiggestRoom() {
        //Arrange
        RoomAreaDTO roomAreaDTOExpected = new RoomAreaDTO();
        roomAreaDTOExpected.setArea(10.0);
        roomAreaDTOExpected.setName("sala");

        //act
        RoomAreaDTO roomAreaDTOCalculated = calculatorService.determineTheBiggestRoom(this.houseDTO);

        //Assert
        Assertions.assertNotEquals(roomAreaDTOExpected.getArea(), roomAreaDTOCalculated.getArea());
        Assertions.assertNotEquals(roomAreaDTOExpected.getName(), roomAreaDTOCalculated.getName());
    }

    @Test
    void shouldDetermineRightAreaRooms(){
        //Arrange
        List<RoomAreaDTO> listRoomsAreasDTOExpeted = new ArrayList<>();
        RoomAreaDTO quarto = new RoomAreaDTO();
        quarto.setName("Quarto");
        quarto.setArea(16.0);

        RoomAreaDTO cozinha = new RoomAreaDTO();
        cozinha.setName("Sala");
        cozinha.setArea(20.0);

        RoomAreaDTO banheiro = new RoomAreaDTO();
        banheiro.setName("Cozinha");
        banheiro.setArea(12.0);

        listRoomsAreasDTOExpeted.add(quarto);
        listRoomsAreasDTOExpeted.add(cozinha);
        listRoomsAreasDTOExpeted.add(banheiro);

        //act
        List<RoomAreaDTO> listRoomsAreasDTOCalculated = calculatorService.calculateAreaRooms(this.houseDTO);

        //Assert TODO usar assert to collections
        Assertions.assertEquals(listRoomsAreasDTOExpeted.get(0).getArea(), listRoomsAreasDTOCalculated.get(0).getArea());
        Assertions.assertEquals(listRoomsAreasDTOExpeted.get(1).getArea(), listRoomsAreasDTOCalculated.get(1).getArea());
        Assertions.assertEquals(listRoomsAreasDTOExpeted.get(2).getArea(), listRoomsAreasDTOCalculated.get(2).getArea());
    }

    @Test
    void shouldDetermineWrongAreaRooms(){
        //Arrange
        List<RoomAreaDTO> listRoomsAreasDTOExpeted = new ArrayList<>();
        RoomAreaDTO quarto = new RoomAreaDTO();
        quarto.setName("Quarto");
        quarto.setArea(20.0);

        RoomAreaDTO cozinha = new RoomAreaDTO();
        cozinha.setName("Sala");
        cozinha.setArea(15.0);

        RoomAreaDTO banheiro = new RoomAreaDTO();
        banheiro.setName("Cozinha");
        banheiro.setArea(10.0);

        listRoomsAreasDTOExpeted.add(quarto);
        listRoomsAreasDTOExpeted.add(cozinha);
        listRoomsAreasDTOExpeted.add(banheiro);

        //act
        List<RoomAreaDTO> listRoomsAreasDTOCalculated = calculatorService.calculateAreaRooms(this.houseDTO);

        //Assert TODO usar assert to collections
        Assertions.assertNotEquals(listRoomsAreasDTOExpeted.get(0).getArea(), listRoomsAreasDTOCalculated.get(0).getArea());
    }


}
