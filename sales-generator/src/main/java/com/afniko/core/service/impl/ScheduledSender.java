package com.afniko.core.service.impl;

import com.afniko.core.service.RestSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledSender {

    private final RestSender sender;

    public ScheduledSender(RestSender sender) {
        this.sender = sender;
    }

    @Scheduled(fixedRate = 2)
    private void sendMessage() {
        sender.sendTestSalesAmount();
    }

}
