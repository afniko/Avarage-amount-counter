package com.afniko.core.service.impl;

import com.afniko.core.service.TimeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimeServiceImpl implements TimeService {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

}
