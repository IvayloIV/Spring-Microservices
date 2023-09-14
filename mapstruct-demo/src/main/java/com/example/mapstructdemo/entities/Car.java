package com.example.mapstructdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String id;
    private String model;
    private Wheel wheel;
    private Double size;
    private String dateCreation;
    private Status status;
    private List<Seat> seats;
}
