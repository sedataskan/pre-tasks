package org.example.carinventory.dto;

import lombok.Data;

@Data
public class CarDto {
    private String id;
    private String model;
    private String color;
    private String engine;
    private int year;
}
