package com.millimeep.venueFinder.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class ErrorHandler extends DefaultResponseErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    @Override
    protected void handleError(ClientHttpResponse response, HttpStatus statusCode) throws IOException {
        logger.debug("eeeep: {}", response.getStatusText());
        super.handleError(response, statusCode);
    }
}
