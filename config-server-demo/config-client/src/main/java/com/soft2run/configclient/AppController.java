package com.soft2run.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class AppController {

    @Value("${name}")
    private String name;

    @Value("${color}")
    private String color;

    @GetMapping("/name")
    public String getName() {
        return name;
    }

    @GetMapping("/color")
    public String getColor() {
        return color;
    }
}
