package org.example.carinventory.mapper;

import org.example.carinventory.dto.CarDto;
import org.example.carinventory.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    //TODO: MapStruct olabilir veya manuel map yapalım *
    //manuel hali düz şöyle -> Car objesi gelir CarDto.setEngine(Car.getEngine()) şeklinde tek tek atanır
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CarDto entityToDto(Car car);

}
