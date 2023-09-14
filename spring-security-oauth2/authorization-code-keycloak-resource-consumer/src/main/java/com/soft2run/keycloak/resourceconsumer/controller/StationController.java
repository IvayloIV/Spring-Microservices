package com.soft2run.keycloak.resourceconsumer.controller;

import com.soft2run.keycloak.resourceconsumer.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Controller
public class StationController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/timetable")
    public String getTimetable(Model model) {
        List<Station> stations = webClient.get()
                .uri("http://localhost:8081/timetable")
                .retrieve()
                .bodyToFlux(Station.class)
                .collectList()
                .block();

        model.addAttribute("name", "Gosho");
        model.addAttribute("stationList", stations);
        return "timetable";
    }
}
