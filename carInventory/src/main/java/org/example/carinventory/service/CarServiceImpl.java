package org.example.carinventory.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.example.carinventory.dto.BaseResponse;
import org.example.carinventory.exception.NoCarOnInventoryException;
import org.example.carinventory.model.Car;
import org.example.carinventory.repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    //TODO: Car listesi dönsün *
    public BaseResponse<Iterable<Car>> getAllCars() {
        var cars = carRepository.findAll();
        //TODO: hiç araba yoksa Http-204 dönsün *
        if (IterableUtils.size(cars) == 0){
            throw new NoCarOnInventoryException("No car on inventory");
        }
        return BaseResponse
                .<Iterable<Car>>builder()
                .status(true)
                .message("Cars has found!")
                .payload(cars)
                .build();
    }

    public ResponseEntity<?> getCarById(String id) {
        return ResponseEntity.ok(carRepository.findCarById(id));
    }

    public ResponseEntity<Car> createCar(Car car) {
        var newCar = Car.builder()
                .id(UUID.randomUUID().toString())
                .model(car.getModel())
                .year(car.getYear())
                .color(car.getColor())
                .motor(car.getMotor())
                .build();
        carRepository.save(newCar);
        return ResponseEntity.created(URI.create("/api/" + newCar.getId())).body(newCar);
    }

    public ResponseEntity<?> updateCar(Car car, String id) {
        if (carRepository.findCarById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        var newCar = Car.builder()
                .id(id)
                .model(car.getModel())
                .year(car.getYear())
                .color(car.getColor())
                .motor(car.getMotor())
                .build();
        carRepository.save(newCar);
        return ResponseEntity.ok("Car " + id + "Has Updated: \n" + newCar);
    }

    public ResponseEntity<?> deleteCarById(String id) {
        if (carRepository.findCarById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        carRepository.deleteById(id);
        return ResponseEntity.ok("Car " + id + " Has Deleted");
    }
}
