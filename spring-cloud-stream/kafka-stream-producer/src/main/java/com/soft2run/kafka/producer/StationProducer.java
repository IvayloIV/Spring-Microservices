package com.soft2run.kafka.producer;

import com.soft2run.kafka.producer.model.Station;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Random;
import java.util.function.Supplier;

@Slf4j
@Component
public class StationProducer {

    private final Random random = new Random();

//    @Bean
    public Supplier<Station> produceStation() {
        return () -> {
            Station station = new Station(random.nextLong(10_001L), "Test address", "Test vehicle name");
            log.info("New Station - {}", station);
            return station;
        };
    }

//    @Bean
    public Supplier<Flux<Station>> produceStations() {
        return () -> {
            Station station1 = new Station(random.nextLong(10_001L), "Test address", "Test vehicle name");
            Station station2 = new Station(random.nextLong(10_001L), "Test address", "Test vehicle name");
            log.info("New Station - {} - {}", station1, station2);
            return Flux.just(station1, station2);
        };
    }
}
