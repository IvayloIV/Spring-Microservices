package com.example.mapstructdemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatModel {
    private String seatColor;
    private String seatModel;
}
