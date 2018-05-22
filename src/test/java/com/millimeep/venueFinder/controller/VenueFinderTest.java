package com.millimeep.venueFinder.controller;

import com.millimeep.venueFinder.services.FourSquare;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(VenueController.class)
public class VenueFinderTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FourSquare service;

    @Test
    public void shouldReturnVenueFromService() throws Exception {
        String name = "Somewhere";
        when(service.venues(name)).thenReturn("Hello Mock");
        this.mockMvc.perform(get("/venue")
                .param("name", name)
        ).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Mock")));
    }
}