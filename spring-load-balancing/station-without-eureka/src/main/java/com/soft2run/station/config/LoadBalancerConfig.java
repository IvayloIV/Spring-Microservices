package com.soft2run.station.config;

import org.springframework.context.annotation.Bean;

public class LoadBalancerConfig {

    @Bean
    public VehicleServiceInstanceListSupplier vehicleServiceInstanceListSupplier() {
        return new VehicleServiceInstanceListSupplier("vehicle-service");
    }
}
