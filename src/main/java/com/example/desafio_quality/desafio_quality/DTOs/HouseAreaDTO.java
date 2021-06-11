package com.example.desafio_quality.desafio_quality.DTOs;

import javax.validation.constraints.*;

public class HouseAreaDTO {
    @NotNull
    @NotBlank
    @NotEmpty(message = "O nome da propriedade não pode estar vazio.")
    @Size(max=30 , message="O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "[A-Z].*", message = "O nome da propriedade deve começar com uma letra maiúscula")
    private String name;
    @NotNull
    private Double area;

    public HouseAreaDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
