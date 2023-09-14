package com.soft2run.keycloak.resourceserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Station {

    private Long id;
    private String name;
    private LocalDateTime arriveTime;
}
