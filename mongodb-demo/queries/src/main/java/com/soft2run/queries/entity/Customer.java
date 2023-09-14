package com.soft2run.queries.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@ToString
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

    @Field("isBlocked")
    private boolean blocked;

    @DBRef
    private Purchase purchase;

    private Double score;
}