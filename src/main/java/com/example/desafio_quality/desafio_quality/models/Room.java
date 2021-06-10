package com.example.desafio_quality.desafio_quality.models;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Validated
public class Room {

    @NotNull
    @NotEmpty(message = "O campo não pode estar vazio")
    @Pattern(regexp = "[A-Z][a-z]+", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    @Size(max=30 , message="O comprimento do cômodo não pode exceder 30 caracteres.")
    private String name;

    @NotNull
    @NotEmpty(message = "A largura do cômodo não pode estar vazia.")
    @DecimalMax(value="25", message="A largura máxima permitida por cômodo é de 25 metros")
    private Double width;
    @NotNull
    @NotEmpty(message = "O comprimento do cômodo não pode estar vazio.")
    @DecimalMax(value="33", message="O comprimento máximo permitido por cômodo é de 33 metros.")
    private Double length;

    public Room() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}
