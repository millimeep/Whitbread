package com.millimeep.venueFinder.controller;


import java.util.concurrent.atomic.AtomicLong;

import com.millimeep.venueFinder.api.VenueFinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VenueController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/venue")
    public VenueFinder greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new VenueFinder(counter.incrementAndGet(), name);
    }
}
