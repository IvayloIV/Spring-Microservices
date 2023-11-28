package com.soft2run.rabbit.integration;

import com.soft2run.rabbit.integration.model.Station;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;

import java.io.File;

@Slf4j
@Configuration
public class StationConsumer {

    @Bean
    public IntegrationFlow integrationFlow() {
        return IntegrationFlows.from("station-topic")
                .transform(Transformers.fromJson(Station.class))
                .transform(s -> {
                    Station station = (Station) s;
                    station.setAddress(station.getAddress().toUpperCase());
                    return station.toString();
                })
                .handle(Files
                        .outboundAdapter(new File("C:\\Users\\User\\Desktop"))
                        .fileExistsMode(FileExistsMode.APPEND)
                        .appendNewLine(true)
                        .fileNameGenerator(f -> "test.txt"))
                .get();
    }
}
