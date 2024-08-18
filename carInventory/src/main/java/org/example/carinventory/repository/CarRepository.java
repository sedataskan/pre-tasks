package org.example.carinventory.repository;

import org.example.carinventory.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String > {
    Car getBySerialNumber(String serialNumber);
    boolean findBySerialNumber(String serialNumber);
}
