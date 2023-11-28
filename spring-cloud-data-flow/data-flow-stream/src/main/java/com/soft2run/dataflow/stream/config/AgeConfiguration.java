package com.soft2run.dataflow.stream.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("people.older")
public class AgeConfiguration {

    private Integer age = 2;
}
