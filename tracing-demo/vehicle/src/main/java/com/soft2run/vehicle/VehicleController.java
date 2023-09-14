package com.soft2run.vehicle;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final Map<Long, String> vehicles = new HashMap<>();

    private Tracer tracer;

    public VehicleController(Tracer tracer) {
        this.tracer = tracer;
        vehicles.put(1L, "Car");
        vehicles.put(2L, "Bus");
        vehicles.put(3L, "Tram");
    }

    @GetMapping("/{id}")
    public String getVehicle(@PathVariable Long id) throws InterruptedException {
        Span dbSearch = tracer.nextSpan().name("Db Search");

        try (Tracer.SpanInScope ws = tracer.withSpan(dbSearch.start())) {
            dbSearch.tag("Test tag", "1234");

            Random random = new Random();
            int multiplier = random.nextInt(5) * 1000;
            Thread.sleep(multiplier);
        } finally {
            dbSearch.end();
        }

        return vehicles.get(id);
    }
}
