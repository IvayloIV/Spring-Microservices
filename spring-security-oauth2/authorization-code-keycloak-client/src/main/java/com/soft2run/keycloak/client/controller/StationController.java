package com.soft2run.keycloak.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StationController {

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/timetable")
    public String getTimetable(Model model) {
        model.addAttribute("name", "Gosho");
        return "timetable";
    }
}
