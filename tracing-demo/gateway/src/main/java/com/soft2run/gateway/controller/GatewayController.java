package com.soft2run.gateway.controller;

import com.soft2run.gateway.model.StationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    private final WebClient webClient;

    @Autowired
    public GatewayController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/{id}")
    public StationResponse getStation(@PathVariable Long id) {
        String url = UriComponentsBuilder.fromUriString("http://localhost:8082/station/{id}").buildAndExpand(id).toUriString();

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(StationResponse.class)
                .block();
    }

    @GetMapping("/ok")
    public String getOk() {
        return "OK";
    }
}
