package org.example.carinventory.service;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.carinventory.exception.CarAlreadyExistsException;
import org.example.carinventory.exception.CarNotFoundException;
import org.example.carinventory.exception.NoCarOnInventoryException;
import org.example.carinventory.model.Car;
import org.example.carinventory.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        var cars = carRepository.findAll();
        if (cars.isEmpty()){
            throw new NoCarOnInventoryException("No car on inventory");
        }
        return cars;
    }

    public Car getCarById(String id) {
        var cars = carRepository.findAll();
        if (cars.isEmpty()){
            throw new CarNotFoundException("There is no car for ID: " + id);
        }
        return carRepository.findCarById(id);
    }

    public Car createCar(Car car, HttpServletResponse response) {
        boolean isInInventory = carRepository.findCarByMotorAndColorAndModelAndYear(car.getMotor(), car.getColor(), car.getModel(), car.getYear());
        if (isInInventory){
            throw new CarAlreadyExistsException("Car already exists on inventory!");
        }
        var newCar = Car.builder()
                .id(UUID.randomUUID().toString())
                .model(car.getModel())
                .year(car.getYear())
                .color(car.getColor())
                .motor(car.getMotor())
                .build();
        carRepository.save(newCar);

        String uri = "/api/Car/" + newCar.getId();
        response.addHeader("Location", uri);
        response.setStatus(HttpServletResponse.SC_CREATED); //201 -> successfully created

        return newCar;
    }

    public Car updateCar(Car car, String id) {
        if (carRepository.findCarById(id) == null) {
            throw new CarNotFoundException("There is no car for ID: " + id);
        }
        var newCar = Car.builder()
                .id(id)
                .model(car.getModel())
                .year(car.getYear())
                .color(car.getColor())
                .motor(car.getMotor())
                .build();
        carRepository.save(newCar);
        return car;
    }

    public Car deleteCarById(String id) {
        var car = carRepository.findCarById(id);
        if (car == null) {
            throw new CarNotFoundException("There is no car for ID: " + id);
        }
        carRepository.deleteById(id);
        return car;
    }
}
