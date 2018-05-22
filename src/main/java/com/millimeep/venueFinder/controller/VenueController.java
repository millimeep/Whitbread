package com.millimeep.venueFinder.controller;


import java.util.concurrent.atomic.AtomicLong;

import com.millimeep.venueFinder.api.VenueFinder;
import com.millimeep.venueFinder.services.FourSquare;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VenueController {

    private final AtomicLong counter = new AtomicLong();
    private final FourSquare fourSquare;

    public VenueController(FourSquare fourSquare) {
        this.fourSquare = fourSquare;
    }

    @RequestMapping("/venue")
    public VenueFinder venues(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new VenueFinder(counter.incrementAndGet(), fourSquare.venues());
    }
}
