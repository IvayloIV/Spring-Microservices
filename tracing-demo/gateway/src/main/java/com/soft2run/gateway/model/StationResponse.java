package com.soft2run.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationResponse {

    private Long id;

    private String address;

    private String vehicle;
}
