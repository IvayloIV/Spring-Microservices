package com.soft2run.dataflow.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station {

    private Long id;

    private String address;

    private String vehicleName;
}
