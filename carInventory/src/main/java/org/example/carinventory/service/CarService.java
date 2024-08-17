package org.example.carinventory.service;

import org.example.carinventory.dto.CarDto;
import java.util.List;

public interface CarService {
    List<CarDto> getAllCars();

    CarDto getCarById(String id);

    CarDto createCar(CarDto car);

    CarDto updateCar(CarDto car);

    CarDto deleteCarById(String id);

}
