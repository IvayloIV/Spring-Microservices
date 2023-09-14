package com.example.mapstructdemo.models;

import com.example.mapstructdemo.entities.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {

    private Long id;
    private String model;
    private Double fuelCapacity;
    private Integer size;
    private String brand;
    private String formattedNum;
    private LocalDate localDate;
    private StatusModel statusModel;
    private List<SeatModel> seats;

    public void addSeatModel(SeatModel seatModel) {
        if (seats == null) {
            seats = new ArrayList<>();
            seats.add(new SeatModel("default", "default"));
        }
        seats.add(seatModel);
    }
}
