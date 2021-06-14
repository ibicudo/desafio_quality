package com.example.desafio_quality.desafio_quality.IntegrationTests;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void calculateTotalArea () throws Exception {
        String request = "{\"name\": \"Apartamento em Osasco\", \"district\": \"Centro\", \"rooms\": [" +
                getRoom("Quarto", 4.0, 4.0) + "," +
                getRoom("Sala", 4.0, 5.0)  + "," +
                getRoom("Cozinha", 4.0, 3.0) +
                "]}";
        this.mockMvc.perform(
                post("/houses/calculateTotalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("48")))
                .andExpect(jsonPath("$.area").value(48.0));
    }

    @Test
    void calculatePrice () throws Exception {
        String request = "{\"name\": \"Apartamento em Osasco\", \"district\": \"Centro\", \"rooms\": [" +
                getRoom("Quarto", 4.0, 4.0) + "," +
                getRoom("Sala", 4.0, 5.0)  + "," +
                getRoom("Cozinha", 4.0, 3.0) +
                "]}";
        this.mockMvc.perform(
                post("/houses/calculatePrice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("288000")))
                .andExpect(jsonPath("$.district").value("Centro"))
                .andExpect(jsonPath("$.price").value(288000.0));
    }

    @Test
    void determineBiggestRoom () throws Exception {
        String request = "{\"name\": \"Apartamento em Osasco\", \"district\": \"Centro\", \"rooms\": [" +
                getRoom("Quarto", 4.0, 4.0) + "," +
                getRoom("Sala", 4.0, 5.0)  + "," +
                getRoom("Cozinha", 4.0, 3.0) +
                "]}";
        this.mockMvc.perform(
                post("/houses/determineBiggesteRoom")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("20")))
                .andExpect(jsonPath("$.name").value("Sala"))
                .andExpect(jsonPath("$.area").value(20.0));
    }

    @Test
    void determineAreaRooms () throws Exception {
        String request = "{\"name\": \"Apartamento em Osasco\", \"district\": \"Centro\", \"rooms\": [" +
                getRoom("Quarto", 4.0, 4.0) + "," +
                getRoom("Sala", 4.0, 5.0)  + "," +
                getRoom("Cozinha", 4.0, 3.0) +
                "]}";
        this.mockMvc.perform(
                post("/houses/calculateAreaRooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].area").value(16.0))
                .andExpect(jsonPath("$.[1].area").value(20.0))
                .andExpect(jsonPath("$.[2].area").value(12.0));
    }

    private String getRoom(String name, double width, double length) {
        return "{\"name\": \""+name+"\", \"width\": "+width+", \"length\": "+length+"}";
    }
}
