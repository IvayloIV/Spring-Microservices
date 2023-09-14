package com.soft2run.keycloak.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {

    private Long id;
    private String name;
    private LocalDateTime arriveTime;
}
