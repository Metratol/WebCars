package com.example.SpringCars.web.controllers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {
    private static final Logger LOG = LogManager.getLogger(Controller.class);
    @GetMapping("/")
    public String homePage() {
        LOG.log(Level.INFO,"Snow main page for random user");
        return "index";
    }

}
