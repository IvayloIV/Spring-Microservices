package com.soft2run.querydsl.entity;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@ToString
@QueryEntity
@Document(collection = "customers")
public class Customer {

    public enum ENTITY {
        LEGAL,
        PHYSICAL
    }

    @Id
    private String id;

    private String firstName;

    private LocalDate birthDate;

    private ENTITY entity;

    private boolean blocked;
}