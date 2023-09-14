package com.example.mapstructdemo.mappers;

import com.example.mapstructdemo.entities.Car;
import com.example.mapstructdemo.entities.Fuel;
import com.example.mapstructdemo.entities.Wheel;
import com.example.mapstructdemo.models.CarModel;
import org.mapstruct.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Mapper(componentModel = "spring",
        uses = {SeatMapper.class, StatusMapper.class},
        imports = {Math.class},
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(CarMapperDecorator.class)
public interface CarMapper {

    @Mappings({
        @Mapping(target = "fuelCapacity", source = "fuel.capacity"),
        @Mapping(target = "id", source = "car.id"),
        @Mapping(target = ".", source = "car.wheel")
    })
    CarModel entityToModel(Car car, Fuel fuel);

    @Mapping(source = "wheel.size", target = "carModel.id")
    void updateModel(Wheel wheel, @MappingTarget CarModel carModel);

    @Mapping(target = "size", source = "car.wheel.size")
    @Mapping(target = "model", source = "car.model")
    @Mapping(target = "formattedNum", source = "size", numberFormat = "#,###.#")
    @Mapping(target = "localDate", source = "dateCreation", dateFormat = "dd.MM.yyyy")
    @Mapping(target = "statusModel", source = "status")
    @Mapping(target = "seats", source = "seats")
    @Mapping(target = "id", source = "id", defaultExpression = "java((long) (Math.random() * 100))")
//    @Mapping(target = "id", constant = "32l")
    @BeanMapping(ignoreByDefault = true)
    CarModel entityToModel(Car car);

    @InheritInverseConfiguration(name = "entityToModel")
    Car modelToEntity(CarModel carModel);

    @InheritConfiguration
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCarModel(Car car, @MappingTarget CarModel carModel);

    List<Car> modelToEntity(List<CarModel> carModels);

    @MapMapping(keyDateFormat = "dd.MM.yyyy")
    Map<String, Car> modelToEntity(Map<LocalDate, CarModel> carModels);

    Stream<Car> modelToEntity(Stream<CarModel> carModels);
}
