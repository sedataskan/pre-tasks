package org.example.carinventory.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.example.carinventory.dto.CarDto;
import org.example.carinventory.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok().body(carService.getAllCars());
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<CarDto> getCarById(@PathVariable String serialNumber) {
        return ResponseEntity.ok().body(carService.getCarBySerialNumber(serialNumber));

    }

    @PostMapping("/")
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto car) {
        var created = carService.createCar(car);
        return ResponseEntity.created(URI.create("api/car/" + "created.getId()")).body(created);
    }

    @PutMapping("/{serialNumber}")
    public ResponseEntity<CarDto> editCarBySerialNumber(@RequestBody CarDto car, @PathVariable String serialNumber) throws BadRequestException {
        if (!car.getSerialNumber().equals(serialNumber)) {
            throw new BadRequestException("Resource serial number and path serial number can not be different");
        }
        var updated = carService.updateCar(car);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("/{serialNumber}")
    public ResponseEntity<String> deleteCar(@PathVariable String serialNumber) {
        carService.deleteCarBySerialNumber(serialNumber);
        return ResponseEntity.ok().body("Car has deleted on this serial number: " + serialNumber);
    }
}
