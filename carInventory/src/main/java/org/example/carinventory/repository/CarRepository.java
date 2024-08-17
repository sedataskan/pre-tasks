package org.example.carinventory.repository;

import org.example.carinventory.dto.CarDto;
import org.example.carinventory.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String > {
    CarDto findCarById(String id);
    boolean findBySerialNumber(String serialNumber);
}
