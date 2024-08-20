package org.example.carinventory.service;

import lombok.RequiredArgsConstructor;
import org.example.carinventory.dto.CarDto;
import org.example.carinventory.exception.CarAlreadyExistsException;
import org.example.carinventory.exception.CarNotFoundException;
import org.example.carinventory.exception.NoCarOnInventoryException;
import org.example.carinventory.mapper.CarMapper;
import org.example.carinventory.model.Car;
import org.example.carinventory.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final NotificationService notificationService;
    private final CarMapper carMapper;

    public List<CarDto> getAllCars() {
        var result = new ArrayList<CarDto>();
        var cars = carRepository.findAll();
        if (cars.isEmpty()){
            throw new NoCarOnInventoryException("No car on inventory");
        }
        for (Car car : cars) {
            result.add(carMapper.entityToDto(car));
        }
        return result;
    }

    public CarDto getCarBySerialNumber(String serialNumber) {
        var car = carRepository.getBySerialNumber(serialNumber);
        if (car == null){
            throw new CarNotFoundException("There is no car for ID: " + serialNumber);
        }
        return car;
    }

    public CarDto createCar(CarDto cardto) {
        if (cardto == null || cardto.getSerialNumber() == null) {
            throw new IllegalArgumentException("Car or SerialNumber cannot be null");
        }

        var existingCar = carRepository.getBySerialNumber(cardto.getSerialNumber());
        if (existingCar != null){
            throw new CarAlreadyExistsException("Car already exists!");
        }
        Car car = carMapper.dtoToEntity(cardto);
        car.setId(UUID.randomUUID().toString());
        car.setCreatedAt(LocalDate.now());
        car.setUpdatedAt(LocalDate.now());

        var newCar = carRepository.save(car);

        notificationService.send("a car created with this id: " + newCar.getId());

        return carMapper.entityToDto(newCar);
    }

    public CarDto updateCar(CarDto cardto) {
        if (carRepository.findBySerialNumber(cardto.getSerialNumber()) == null) {
            throw new CarNotFoundException("There is no car for this Serial Number: " + cardto.getSerialNumber());
        }
        Car oldCar = carMapper.dtoToEntity(carRepository.findBySerialNumber(cardto.getSerialNumber()));
        oldCar.setUpdatedAt(LocalDate.now());
        oldCar.setModel(cardto.getModel());
        oldCar.setYear(cardto.getYear());
        oldCar.setEngine(cardto.getEngine());

        Car updatedCar = carRepository.save(oldCar);
        notificationService.send("a car updated with this id: " + updatedCar.getId());
        return carMapper.entityToDto(updatedCar);
    }

    public void deleteCarBySerialNumber(String serialNumber) {
        var car = carRepository.getBySerialNumber(serialNumber);
        if (car == null) {
            throw new CarNotFoundException("There is no car for Serial Number: " + serialNumber);
        }
        carRepository.delete(carMapper.dtoToEntity(car));
    }
}
