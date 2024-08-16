package org.example.carinventory.service;

import jakarta.servlet.http.HttpServletResponse;
import org.example.carinventory.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();

    Car getCarById(String id);

    Car createCar(Car car, HttpServletResponse response);

    Car updateCar(Car car, String id);

    Car deleteCarById(String id);
}
