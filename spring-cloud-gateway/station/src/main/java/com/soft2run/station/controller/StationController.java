package com.soft2run.station.controller;

import com.soft2run.station.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/station")
public class StationController {

    private final Map<Long, String> stations = new HashMap<>();
    private final WebClient.Builder webClient;

    @Autowired
    public StationController(WebClient.Builder webClient) {
        this.webClient = webClient;
        stations.put(1L, "Address 1");
        stations.put(2L, "Address 2");
        stations.put(3L, "Address 3");
    }

    @GetMapping("/{id}")
    public Station getStation(@PathVariable Long id) {
        System.out.println(id);
        String url = UriComponentsBuilder.fromUriString("http://vehicle/vehicle/{id}").buildAndExpand(id).toUriString();

        String vehicle = webClient.build().get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        Station station = new Station();
        station.setId(id);
        station.setAddress(stations.get(id));
        station.setVehicle(vehicle);

        return station;
    }
}
