package org.example.carinventory.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.carinventory.dto.BaseResponse;
import org.example.carinventory.model.Car;
import org.example.carinventory.service.CarService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/")
    public BaseResponse<Object> getAllCars() {
        return BaseResponse
                .builder()
                .status(true)
                .payload(carService.getAllCars())
                .build();
    }

    @GetMapping("/{id}")
    public BaseResponse<Object> getCarById(@PathVariable String id) {
        return BaseResponse
                .builder()
                .status(true)
                .payload(carService.getCarById(id))
                .build();
    }

    @PostMapping("/")
    public BaseResponse<Object> createCar(@RequestBody Car car, HttpServletResponse response) {
        return BaseResponse
                .builder()
                .status(true)
                .payload(carService.createCar(car, response))
                .build();
    }

    @PutMapping("/{id}")
    public BaseResponse<Object> editCarById(@RequestBody Car car, @PathVariable String id) {
        return BaseResponse
                .builder()
                .status(true)
                .payload(carService.updateCar(car, id))
                .build();
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Object> deleteCar(@PathVariable String id) {
        return BaseResponse
                .builder()
                .status(true)
                .payload(carService.deleteCarById(id))
                .build();
    }

}
