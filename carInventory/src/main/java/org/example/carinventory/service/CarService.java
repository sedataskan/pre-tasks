package org.example.carinventory.service;

import org.example.carinventory.model.Car;
import org.springframework.http.ResponseEntity;

public interface CarService {
    ResponseEntity<?> getAllCars();

    ResponseEntity<?> getCarById(String id);

    ResponseEntity<?> createCar(Car car);

    ResponseEntity<?> updateCar(Car car, String id);

    ResponseEntity<?> deleteCarById(String id);
    //TODO: metodlar buraya alınack
}
