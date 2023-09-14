package com.soft2run.queries.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@ToString
@Document(collection = "purchases")
public class Purchase {

    @Id
    private String id;

    @TextIndexed
    private String name;

    @TextIndexed(weight = 2)
    private String description;

    @Indexed
    private Double price;
}
