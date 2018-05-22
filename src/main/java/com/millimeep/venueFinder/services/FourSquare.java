package com.millimeep.venueFinder.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class FourSquare implements EnvironmentAware {
    private final RestTemplate restTemplate;
    private String client_secret;
    private String client_id;

    public FourSquare(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public String venues(String name) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl("https://api.foursquare.com/v2/venues/explore")
                .queryParam("client_id", client_id)
                .queryParam("client_secret", client_secret)
                .queryParam("v", "20180323")
                .queryParam("near", name)
                .build().toUri();
        return restTemplate.getForObject(uri, String.class);
    }

    @Override
    public void setEnvironment(Environment environment) {
        client_id = environment.getProperty("client_id");
        client_secret = environment.getProperty("client_secret");
    }
}
