package com.example.mapstructdemo.mappers;

import com.example.mapstructdemo.entities.Seat;
import com.example.mapstructdemo.exception.SeatValidator;
import com.example.mapstructdemo.models.SeatModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        uses = {SeatValidator.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeatMapper {

    @Mapping(target = "seatColor", source = "seat.color", qualifiedByName = "validateSeatColor")
    @Mapping(target = "seatModel", source = "seat.model")
    @BeanMapping(ignoreByDefault = true)
    SeatModel entityToModel(Seat seat);

    @InheritInverseConfiguration(name = "entityToModel")
    Seat modelToEntity(SeatModel seatModel);

    @InheritConfiguration
    void updateModel(Seat seat, @MappingTarget SeatModel seatModel);

    @InheritConfiguration
    void updateEntity(SeatModel seatModel, @MappingTarget Seat seat);

    @BeforeMapping
    default void validateEntity(Seat seat) {
        if (seat.getModel() != null) {
            System.out.println("Seat Validation");
        }
    }

    @BeforeMapping
    default void validateModel(SeatModel seatModel) {
        if (seatModel.getSeatModel() != null) {
            System.out.println("Model Validation ");
        }
    }

    @BeforeMapping
    default void validate() {
        System.out.println("Model Validation ");
    }

    @AfterMapping
    default void changeSeat1(Seat seat) {
        if (seat.getModel() != null) {
            System.out.println("Seat change 1");
        }
    }

    @AfterMapping
    default void changeSeatModel2(SeatModel seatModel) {
        if (seatModel.getSeatModel() != null) {
            System.out.println("SeatModel change 1");
        }
    }

    @AfterMapping
    default void changeSeatModel3(Seat seat, @MappingTarget SeatModel seatModel) {
        if (seatModel.getSeatModel() != null) {
            System.out.println("SeatModel change 1");
        }
    }

    @AfterMapping
    default void change() {
        System.out.println("SeatModel change 1");
    }

}
