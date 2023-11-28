package com.soft2run.dataflow.stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soft2run.dataflow.stream.config.AgeConfiguration;
import com.soft2run.dataflow.stream.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@Slf4j
@SpringBootApplication
public class StreamApplication {

    @Autowired
    private AgeConfiguration ageConfiguration;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        SpringApplication.run(StreamApplication.class, args);
    }

    @Bean
    public Function<String, String> getOlder() {
        return v -> {
            Person person;
            try {
                person = objectMapper.readValue(v, Person.class);
            } catch (JsonProcessingException e) {
                log.error("Error while parsing: {}", v);
                return null;
            }

            person.setAge(person.getAge() - ageConfiguration.getAge());
            try {
                return objectMapper.writeValueAsString(person);
            } catch (JsonProcessingException e) {
                log.error("Error while writing json as a String: {}", person);
                return null;
            }
        };
    }
}
