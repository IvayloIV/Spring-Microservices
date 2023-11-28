package com.soft2run.station.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Flux;

import java.util.List;

public class VehicleServiceInstanceListSupplier implements ServiceInstanceListSupplier {

    private final String serviceId;

    public VehicleServiceInstanceListSupplier(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        DefaultServiceInstance localhost1 = new DefaultServiceInstance("1", serviceId, "localhost", 8081, false);
        DefaultServiceInstance localhost2 = new DefaultServiceInstance("2", serviceId, "localhost", 8082, false);
        return Flux.just(List.of(localhost1, localhost2));
    }
}
