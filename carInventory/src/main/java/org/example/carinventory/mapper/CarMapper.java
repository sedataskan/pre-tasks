package org.example.carinventory.mapper;

import org.example.carinventory.dto.CarDto;
import org.example.carinventory.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarMapper {
    //TODO: MapStruct olabilir veya manuel map yapalım *

    //manuel hali düz şöyle -> Car objesi gelir CarDto.setEngine(Car.getEngine()) şeklinde tek tek atanır
    @Mapping(target = "serialNumber", source = "serialNumber")
    CarDto entityToDto(Car car);
    Car dtoToEntity(CarDto carDto);

}
