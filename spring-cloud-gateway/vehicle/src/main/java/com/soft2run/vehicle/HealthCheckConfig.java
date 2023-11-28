package com.soft2run.vehicle;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthCheckConfig implements HealthIndicator {

    private static int counter = 1;

    @Override
    public Health health() {
        System.out.println("Health: " + counter);

        if (counter++ % 4 == 0) {
            return Health.down().withDetail("Ops", counter).build();
        }

        return Health.up().build();
    }
}
