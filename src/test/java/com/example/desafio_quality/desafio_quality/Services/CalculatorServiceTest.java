package com.example.desafio_quality.desafio_quality.Services;

import com.example.desafio_quality.desafio_quality.DTOs.HouseAreaDTO;
import com.example.desafio_quality.desafio_quality.models.House;
import com.example.desafio_quality.desafio_quality.models.Room;
import com.example.desafio_quality.desafio_quality.repositories.CalculatorRepository;
import com.example.desafio_quality.desafio_quality.services.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorServiceTest {

    @MockBean
    private CalculatorRepository calculatorRepository;

    @Autowired
    private CalculatorService calculatorService;

    House house;

    @BeforeEach
    public void setUp (){
        this.house = new House();
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
        roomC.setName("Sala");
        roomC.setLength(3.0);
        roomC.setWidth(4.0);
        listRooms.add(roomC);


        house.setName("Apartamento em Barueri");
        house.setDistrict("Tupancy");
        house.setRooms(listRooms);
    }

    @Test
    void shouldCalculateRightTotalArea() throws Exception{
        //Arrange
        Double area = 0.0;
        List<Room> listRooms = this.house.getRooms();
        for(Room room : listRooms){
            area = area + room.getLength()*room.getWidth();
        }
        HouseAreaDTO houseAreaExpeted = new HouseAreaDTO();
        houseAreaExpeted.setArea(area);
        houseAreaExpeted.setName(this.house.getName());

        Mockito.when(calculatorRepository.calculateArea(Mockito.any(House.class))).thenReturn(houseAreaExpeted);

        //act
        HouseAreaDTO houseAreaCalculated = calculatorService.calculateTotalArea(this.house);

        //Assert
        Assertions.assertEquals(houseAreaExpeted.getArea() , houseAreaCalculated.getArea());

    }

    @Test
    void shouldCalculateWrongtTotalArea() throws Exception{
        //Arrange
        HouseAreaDTO houseAreaExpeted = new HouseAreaDTO();
        houseAreaExpeted.setArea(45.0);
        houseAreaExpeted.setName(this.house.getName());

        Mockito.when(calculatorRepository.calculateArea(Mockito.any(House.class))).thenReturn(houseAreaExpeted);

        //act
        HouseAreaDTO houseAreaCalculated = calculatorService.calculateTotalArea(this.house);

        //Assert
        Assertions.assertNotEquals(houseAreaExpeted.getArea() , houseAreaCalculated.getArea());

    }



}
