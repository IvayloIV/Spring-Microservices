package com.soft2run.keycloak.resourceserver.controller;

import com.soft2run.keycloak.resourceserver.model.Station;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StationController {

    private List<Station> stations = new ArrayList<>();

    public StationController() {
        stations.add(new Station(1L, "Test 1", LocalDateTime.now().plus(1, ChronoUnit.DAYS)));
        stations.add(new Station(2L, "Test 2", LocalDateTime.now().plus(2, ChronoUnit.DAYS)));
        stations.add(new Station(3L, "Test 3", LocalDateTime.now().plus(3, ChronoUnit.DAYS)));
    }

    @GetMapping("/timetable")
    public List<Station> getTimetable() {
        return stations;
    }

    @GetMapping("/timetable/last")
    public Station getLastTimetable() {
        return stations.get(stations.size() - 1);
    }
}
