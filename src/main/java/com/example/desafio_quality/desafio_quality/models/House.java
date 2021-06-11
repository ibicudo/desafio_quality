package com.example.desafio_quality.desafio_quality.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Validated
public class House {

    @NotNull
    @NotBlank
    @NotEmpty(message = "O nome da propriedade não pode estar vazio.")
    @Size(max=30 , message="O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "[A-Z].*", message = "O nome da propriedade deve começar com uma letra maiúscula")
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty(message = "O bairro não pode estar vazio.")
    @Size(max=45 , message="O comprimento do bairro não pode exceder 45 caracteres.")
    private String district;

    @Valid
    @NotNull(message = "É necessário ter uma lista de cômodos")
    @Size(min = 1, message = "É necessário ter pelo menos um cômodo na lista")
    private List<Room> rooms;

    @JsonIgnore
    private Double valueByDistricts;

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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Double getValueByDistricts() {
        return valueByDistricts;
    }

    public void setValueByDistricts(String districts) {
        District mapDistrict = new District();
        this.valueByDistricts = mapDistrict.getMapDistricts().get(districts);
    }
}
