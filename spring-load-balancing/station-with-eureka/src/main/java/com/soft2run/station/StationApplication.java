package com.soft2run.station;

import com.soft2run.station.config.LoadBalancerAlgorithmConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

@LoadBalancerClient(name = "vehicle", configuration = LoadBalancerAlgorithmConfig.class)
@SpringBootApplication
public class StationApplication {

    public static void main(String[] args) {
        SpringApplication.run(StationApplication.class, args);
    }

}
