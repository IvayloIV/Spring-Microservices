package com.soft2run.springrediscache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/{id}")
    public Trip getById(@PathVariable String id) {
        return tripService.getTripById(id);
    }
}
