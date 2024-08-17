package org.example.carinventory.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.example.carinventory.dto.CarDto;
import org.example.carinventory.mapper.CarMapper;
import org.example.carinventory.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/Car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    @GetMapping("/")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok().body(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable String id) {
        return ResponseEntity.ok().body(carService.getCarById(id));

    }

    @PostMapping("/")
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto car) {
        var created = carService.createCar(car);
        return ResponseEntity.created(URI.create(created.getId())).body(created);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> editCarById(@RequestBody CarDto car, @PathVariable String id) throws BadRequestException {
        if (!car.getId().equals(id)) {
            throw new BadRequestException("Resource Id and path id can not be different");
        }
        var updated = carService.updateCar(car);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarDto> deleteCar(@PathVariable String id) {
        return ResponseEntity.ok().body("Car has deleted on this id: " + carService.deleteCarById(id));
    }

}
