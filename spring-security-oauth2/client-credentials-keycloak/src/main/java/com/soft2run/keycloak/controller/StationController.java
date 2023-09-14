package com.soft2run.keycloak.controller;

import com.soft2run.keycloak.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class StationController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/")
    public Station getTimetable() {
        return webClient.get()
                .uri("http://localhost:8081/timetable/last")
                .retrieve()
                .bodyToMono(Station.class)
                .block();
    }
}
