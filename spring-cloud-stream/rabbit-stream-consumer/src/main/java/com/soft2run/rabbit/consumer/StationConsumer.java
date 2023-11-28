package com.soft2run.rabbit.consumer;

import com.soft2run.rabbit.consumer.model.Station;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
@Component
public class StationConsumer {

    @Bean
    public Consumer<Station> consumeStation() {
        return s -> log.info("Consumed Station - {}", s);
    }

//    @Bean
    public Function<Station, Station> processStation() {
        return s -> {
            log.info("Processed Station - {}", s);
            s.setAddress(s.getAddress() + " Processed");
            return s;
        };
    }

//    @Bean
    public Consumer<Station> consumeStationV1() {
        return s -> log.info("Consumed Station v1 - {}", s);
    }

//    @Bean
    public Consumer<Message<Station>> consumeStationV2() {
        return s -> log.info("Consumed Station v2 - {}", s);
    }
}
