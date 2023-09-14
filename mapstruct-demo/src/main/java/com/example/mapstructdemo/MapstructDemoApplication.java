package com.example.mapstructdemo;

import com.example.mapstructdemo.entities.*;
import com.example.mapstructdemo.mappers.CarMapper;
import com.example.mapstructdemo.models.CarModel;
import com.example.mapstructdemo.models.StatusModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootApplication
public class MapstructDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MapstructDemoApplication.class, args);
		CarMapper carMapper = context.getBean(CarMapper.class);

		Seat seat1 = new Seat("black", "test1");
		Seat seat2 = new Seat("purple", "test2");

		Wheel wheel = new Wheel(4, "BrandX");
		Car car = new Car("1", "BMW", wheel, 454d,"01.12.2015", Status.ACTIVE, List.of(seat1, seat2));
		Fuel fuel = new Fuel("2", 54.2);
		CarModel carModel = carMapper.entityToModel(car, fuel);
//		System.out.println(carModel);

		CarModel carModel2 = new CarModel();
		carMapper.updateModel(wheel, carModel2);
//		System.out.println(carModel2);

		CarModel carModel3 = new CarModel();
		carModel3.setId(33L);
//		CarModel carModel4 = carMapper.updateCarModel(car1, carModel3);
//		System.out.println(carModel4);

//		CarModel carModel5 = carMapper.entityToModel(car1);
//		System.out.println(carModel5);

//		CarModel carModel1 = new CarModel();
//		carModel1.setId(123L);
//		carModel1.setModel("OPE");
//		carModel1.setFormattedNum("123,456.78");
//		carModel1.setStatusModel(StatusModel.SI_INACTIVE);
//		carModel1.setLocalDate(LocalDate.now());
//
//		CarModel carModel4 = new CarModel();
//		carModel4.setId(125L);
//		carModel4.setModel("OPEL");
//		carModel4.setFormattedNum("111");
//		carModel4.setStatusModel(StatusModel.SI_ACTIVE);
//		carModel4.setLocalDate(LocalDate.now());
//
//		List<Car> cars = carMapper.modelToEntity(List.of(carModel1, carModel4));
//		Map<String, Car> carMap = carMapper.modelToEntity(Map.of(
//				LocalDate.now(), carModel1,
//				LocalDate.now().plusDays(1), carModel4));
//		Stream<Car> cars2 = carMapper.modelToEntity(Stream.of(carModel1, carModel4));
//		System.out.println(carModel1);

		Car car1 = new Car(null, "BMW", wheel, 458d, "01.12.2016", Status.INACTIVE, List.of(seat1, seat2));
		CarModel carModel1 = carMapper.entityToModel(car1);
		System.out.println(carModel1);
	}
}
