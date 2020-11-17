package com.afniko.core.service;

import org.springframework.http.ResponseEntity;

public interface RestHandler {

    <S> ResponseEntity<S> doPost(String endpointUrl, Class<S> responseBodyClz);

}
