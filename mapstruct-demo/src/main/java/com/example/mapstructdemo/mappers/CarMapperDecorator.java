package com.example.mapstructdemo.mappers;

import com.example.mapstructdemo.entities.Car;
import com.example.mapstructdemo.models.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class CarMapperDecorator implements CarMapper {

    @Autowired
    @Qualifier("delegate")
    private CarMapper carMapper;

    @Override
    public CarModel entityToModel(Car car) {
        CarModel carModel = carMapper.entityToModel(car);
        carModel.setId(carModel.getId() + 1000);
        return carModel;
    }
}
