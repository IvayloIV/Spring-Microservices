package com.soft2run.kafka.producer;

import com.soft2run.kafka.producer.model.Station;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/station")
public class StationController {

    public final StreamBridge streamBridge;
    private final Random random = new Random();

    @Autowired
    public StationController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping("/new")
    public Station createStation() {
        Station station = new Station(random.nextLong(10_001L), "Test address", "Test vehicle name");
        log.info("New station has been created - {}", station);
        streamBridge.send("produceStation-out-0", station);
        return station;
    }

    @GetMapping("/new/{version}")
    public Station createStationVersion(@PathVariable Long version) {
        Station station = new Station(random.nextLong(10_001L), "Test address", "Test vehicle name");
        Message<Station> message = MessageBuilder
                .withPayload(station)
                .setHeader("version", version)
                .build();
        log.info("New station has been created - {} - version {}", station, version);
        streamBridge.send("produceStation-out-0", message);
        return station;
    }
}
