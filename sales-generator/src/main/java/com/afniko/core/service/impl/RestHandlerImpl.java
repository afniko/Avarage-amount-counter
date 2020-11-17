package com.afniko.core.service.impl;

import com.afniko.core.service.RestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Service
public class RestHandlerImpl implements RestHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestHandlerImpl.class);

    private final String backendBaseUrl;

    private final RestOperations rest;

    public RestHandlerImpl(
            @Value("${backend.base-url}") String backendBaseUrl,
            RestOperations rest) {
        this.backendBaseUrl = backendBaseUrl;
        this.rest = rest;
    }

    @Override
    public <S> ResponseEntity<S> doPost(String endpointUrl, Class<S> responseBodyClz) {

        String requestUrl = backendBaseUrl + endpointUrl;
        HttpHeaders requestHeaders = createRequestHeaders();
        HttpEntity<Void> requestEntity = new HttpEntity<>(requestHeaders);

        ResponseEntity<S> response = rest.exchange(
                requestUrl,
                HttpMethod.POST,
                requestEntity,
                responseBodyClz
        );

        LOG.debug("In doGet - GET request to URL:[{}] was successful", requestUrl);
        return response;
    }

    private HttpHeaders createRequestHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return headers;
    }

}
