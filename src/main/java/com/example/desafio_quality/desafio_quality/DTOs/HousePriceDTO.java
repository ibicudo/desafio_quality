package com.example.desafio_quality.desafio_quality.DTOs;

public class HousePriceDTO {
    private String name;
    private String district;
    private Double price;

    public HousePriceDTO() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
