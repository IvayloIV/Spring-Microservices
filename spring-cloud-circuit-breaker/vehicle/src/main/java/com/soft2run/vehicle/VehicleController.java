package com.soft2run.vehicle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final Map<Long, String> vehicles = new HashMap<>();


    public VehicleController() {
        vehicles.put(1L, "Car");
        vehicles.put(2L, "Bus");
        vehicles.put(3L, "Tram");
    }

    @GetMapping("/{id}")
    public String getVehicle(@PathVariable Long id) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Vehicle with id: " + id);
        return vehicles.get(id);
    }
}
