package org.example.carinventory.service;

import lombok.RequiredArgsConstructor;
import org.example.carinventory.dto.CarDto;
import org.example.carinventory.exception.CarAlreadyExistsException;
import org.example.carinventory.exception.CarNotFoundException;
import org.example.carinventory.exception.NoCarOnInventoryException;
import org.example.carinventory.model.Car;
import org.example.carinventory.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final NotificationService notificationService;

    public List<CarDto> getAllCars() {
        var cars = carRepository.findAll();
        if (cars.isEmpty()){
            throw new NoCarOnInventoryException("No car on inventory");
        }
        return cars;
    }

    public CarDto getCarById(String id) {
        var cars = carRepository.findAll();
        if (cars.isEmpty()){
            throw new CarNotFoundException("There is no car for ID: " + id);
        }
        return carRepository.findCarById(id);
    }

    public CarDto createCar(Car car) {
        boolean isInInventory = carRepository.findBySerialNumber(car.getSerialNumber());
        if (isInInventory){
            throw new CarAlreadyExistsException("Car already exists on inventory!");
        }
        var newCar = Car.builder()
                .id(UUID.randomUUID().toString())
                .model(car.getModel())
                .year(car.getYear())
                .color(car.getColor())
                .engine(car.getEngine())
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();
        carRepository.save(newCar);
        notificationService.send("a car created with this id: " + newCar.getId());
        //buralar mapping
        return newCar;
    }

    public CarDto updateCar(Car car) {
        if (carRepository.findCarById(car.getId()) == null) {
            throw new CarNotFoundException("There is no car for ID: " + car.getId());
        }
        var newCar = Car.builder()
                .id(car.getId())
                .model(car.getModel())
                .year(car.getYear())
                .color(car.getColor())
                .engine(car.getEngine())
                .build();
        carRepository.save(newCar);
        //buralarda mapping olucak
        return newCar;
    }

    public CarDto deleteCarById(String id) {
        var car = carRepository.findCarById(id);
        if (car == null) {
            throw new CarNotFoundException("There is no car for ID: " + id);
        }
        carRepository.deleteById(id);
        return car;
    }
}
