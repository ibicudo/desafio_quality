package com.example.desafio_quality.desafio_quality.models;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.List;

@Validated
public class House {

    @NotNull
    @NotEmpty(message = "O nome da propriedade não pode estar vazio.")
    @Size(max=30 , message="O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "[A-Z][a-z]+", message = "O nome da propriedade deve começar com uma letra maiúscula")
    private String name;

    @NotNull
    @NotEmpty(message = "O bairro não pode estar vazio.")
    @Size(max=45 , message="O comprimento do bairro não pode exceder 45 caracteres.")
    private String district;

    private List<Room> room;

    public House() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }
}
