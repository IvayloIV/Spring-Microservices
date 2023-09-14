package com.soft2run.springrediscache;

import lombok.Data;

import java.io.Serializable;

@Data
public class Trip implements Serializable {

    private String id;

    private Double maxSpeed;

    private String summary;
}
