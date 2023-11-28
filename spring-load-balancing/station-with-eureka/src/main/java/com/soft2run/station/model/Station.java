package com.soft2run.station.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station {

    private Long id;

    private String address;

    private String vehicle;
}
