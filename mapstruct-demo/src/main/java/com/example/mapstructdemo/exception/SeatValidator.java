package com.example.mapstructdemo.exception;

import org.mapstruct.Named;

public class SeatValidator {

    @Named("validateSeatColor")
    public static String validateSeatColor(String seatColor) {
        if (seatColor == null) {
            throw new IllegalArgumentException();
        }
        return seatColor;
    }
}
