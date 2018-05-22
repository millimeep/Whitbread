package com.millimeep.venueFinder.controller;


import com.millimeep.venueFinder.services.FourSquare;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class VenueController {

    private final AtomicLong counter = new AtomicLong();
    private final FourSquare fourSquare;

    public VenueController(FourSquare fourSquare) {
        this.fourSquare = fourSquare;
    }

    @RequestMapping(value = "/venue", produces = "application/json")
    public String venues(@RequestParam(value = "name", defaultValue = "World") String name) {
        return fourSquare.venues(name);
    }
}
