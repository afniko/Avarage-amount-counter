package com.afniko.core.service.impl;

import com.afniko.core.service.GeneratorRandomDouble;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeneratorRandomDoubleImpl implements GeneratorRandomDouble {

    private final Random random = new Random();

    @Override
    public Double getRandom() {
        return 10000 * random.nextDouble();
    }
}
