package com.millimeep.venueFinder.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(FourSquare.class)
public class FourSquareTest {

    @Autowired
    private FourSquare client;

    @Autowired
    private MockRestServiceServer server;

    private final String expectedVenues = "some venues";
    private final String location = "somewhere";

    @Before
    public void setUp() {

        this.server.expect(requestTo(
                "https://api.foursquare.com/v2/venues/explore?client_id&client_secret&v=20180323&near=" + location))
                .andRespond(withSuccess(expectedVenues, MediaType.APPLICATION_JSON));
    }

    @Test
    public void whenCallingGetUserDetails_thenClientMakesCorrectCall() {

        String details = this.client.venues(location);

        Assert.assertEquals(expectedVenues, details);
    }
}