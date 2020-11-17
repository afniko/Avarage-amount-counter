package com.afniko.core.service.impl;

import com.afniko.core.service.DataSalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AutoRemoveRecords {

    private static final Logger LOG = LoggerFactory.getLogger(AutoRemoveRecords.class);

    private final DataSalesService dataSalesService;

    public AutoRemoveRecords(DataSalesService dataSalesService) {
        this.dataSalesService = dataSalesService;
    }

    @Scheduled(fixedRate = 1000)
    public void removeUnnecessaryRecords() {
        LOG.debug("In removeUnnecessaryRecords - remove older records");
        dataSalesService.removeOlderRecords();
    }
}
