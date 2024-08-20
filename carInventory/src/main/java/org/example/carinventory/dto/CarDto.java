package org.example.carinventory.dto;

import lombok.Data;

@Data
public class CarDto {
    private String model;
    private String color;
    private String engine;
    private int year;
    private String serialNumber;
}
