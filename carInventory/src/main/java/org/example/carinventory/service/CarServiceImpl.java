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
        return CarMapper.INSTANCE.entityToDto(car);
    }

    public CarDto createCar(CarDto car) {
//        var isInInventory = carRepository.findBySerialNumber(car.getSerialNumber());
//        if (isInInventory){
//            throw new CarAlreadyExistsException("Car already exists on inventory!");
//        }
        var newCar = Car.builder()
                .id(UUID.randomUUID().toString())
                .model(car.getModel())
                .year(car.getYear())
                .color(car.getColor())
                .engine(car.getEngine())
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .serialNumber(car.getSerialNumber())
                .build();
        carRepository.save(newCar);
        notificationService.send("a car created with this id: " + newCar.getId());
        return CarMapper.INSTANCE.entityToDto(newCar);
    }

    public CarDto updateCar(CarDto car) {
        if (!carRepository.findBySerialNumber(car.getSerialNumber())) {
            throw new CarNotFoundException("There is no car for this Serial Number: " + car.getSerialNumber());
        }
        var updatedCar = Car.builder()
                .model(car.getModel())
                .year(car.getYear())
                .color(car.getColor())
                .engine(car.getEngine())
                .updatedAt(LocalDate.now())
                .build();
        carRepository.save(updatedCar);
        return CarMapper.INSTANCE.entityToDto(updatedCar);
    }

    public void deleteCarBySerialNumber(String serialNumber) {
        var car = carRepository.getBySerialNumber(serialNumber);
        if (car == null) {
            throw new CarNotFoundException("There is no car for Serial Number: " + serialNumber);
        }
        carRepository.delete(car);
    }
}
