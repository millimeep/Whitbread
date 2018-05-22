package com.millimeep.venueFinder.api;

public class VenueFinder {
    private final long id;
    private final String venue;

    public VenueFinder(long id, String venue) {
        this.id = id;
        this.venue = venue;
    }

    public long getId() {
        return id;
    }

    public String getVenue() {
        return venue;
    }}
