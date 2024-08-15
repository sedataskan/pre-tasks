package org.example.carinventory.controller;

import lombok.RequiredArgsConstructor;
import org.example.carinventory.model.Car;
import org.example.carinventory.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Car")
@RequiredArgsConstructor
public class CarController {

    //todo: Entity yerine DTO kullanalım.

    private final CarService carService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCars() {
        //TODO: Global exception handler olsun
        return carService.getAllCars();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCarById(@PathVariable String id) {

        return carService.getCarById(id);

    }

    @PostMapping("/")
    public ResponseEntity<?> createCar(@RequestBody Car car) {

        return carService.createCar(car);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editCarById(@RequestBody Car car, @PathVariable String id) {

        return carService.updateCar(car, id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable String id) {

        return carService.deleteCarById(id);

    }

}
