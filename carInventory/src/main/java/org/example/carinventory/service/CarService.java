package org.example.carinventory.service;

import org.example.carinventory.dto.CarDto;
import java.util.List;

public interface CarService {
    List<CarDto> getAllCars();

    CarDto getCarBySerialNumber(String id);

    CarDto createCar(CarDto car);

    CarDto updateCar(CarDto car);

    void deleteCarBySerialNumber(String serialNumber);

}
