package com.afniko.core.service.impl;

import com.afniko.core.service.GeneratorRandomDouble;
import com.afniko.core.service.RestHandler;
import com.afniko.core.service.RestSender;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class RestSenderImpl implements RestSender {

    private static final String URL = "/sales?%s=%f";

    private final RestHandler restHandler;

    private final GeneratorRandomDouble generator;

    public RestSenderImpl(RestHandler restHandler, GeneratorRandomDouble generator) {
        this.restHandler = restHandler;
        this.generator = generator;
    }

    @Override
    public void sendTestSalesAmount() {
        String nameOfParameter = "salesAmount";
        double randomDouble = generator.getRandom();
        restHandler.doPost(format(URL, nameOfParameter, randomDouble), Void.class);
    }

}
