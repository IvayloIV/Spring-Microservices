package com.soft2run.springrediscache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    @Cacheable("MyHash")
    public Trip getTripById(String id) {
        System.out.println("Hereeee");
        Trip trip = new Trip();
        trip.setId(id);
        trip.setSummary("Cool");
        trip.setMaxSpeed(432.2);
        return trip;
    }
}
