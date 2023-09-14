package com.example.mapstructdemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WheelModel {
    private Integer size;
    private String brand;
}
