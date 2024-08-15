package org.example.carinventory.repository;

import org.example.carinventory.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, String > {
    Car findCarById(String id);
}
