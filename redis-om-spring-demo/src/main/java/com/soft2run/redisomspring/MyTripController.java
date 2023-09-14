package com.soft2run.redisomspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTripController {

    @Autowired
    private MyTripRepository myTripRepository;

    @GetMapping
    public Iterable<MyTrip> getMyTrips() {
        Iterable<MyTrip> trips = myTripRepository.findAll();
        return trips;
    }

    @GetMapping("/save")
    public String save() {
        MyTrip myTrip = new MyTrip();
        myTrip.setId("7");
        myTrip.setTripDistance(46.2);
        myTrip.setSummary("Cool");
        myTripRepository.save(myTrip);
        return "Done";
    }
}
