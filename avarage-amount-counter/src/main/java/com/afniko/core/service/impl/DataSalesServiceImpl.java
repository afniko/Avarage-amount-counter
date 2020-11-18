package com.afniko.core.service.impl;

import com.afniko.core.model.SalesAmountInfo;
import com.afniko.core.model.StatisticInfo;
import com.afniko.core.repository.DataRepository;
import com.afniko.core.service.DataSalesService;
import com.afniko.core.service.TimeService;
import com.afniko.exception.NotSavedSalesAmountInfoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class DataSalesServiceImpl implements DataSalesService {

    private static final Logger LOG = LoggerFactory.getLogger(DataSalesServiceImpl.class);

    private final TimeService timeService;

    private final DataRepository dataRepository;

    public DataSalesServiceImpl(TimeService timeService, DataRepository dataRepository) {
        this.timeService = timeService;
        this.dataRepository = dataRepository;
    }

    @Override
    public synchronized void save(SalesAmountInfo salesAmountInfo) {
        LOG.debug("In save - set time and save info");
        setTimeOfSale(salesAmountInfo);
        final boolean resultOfStore = dataRepository.save(salesAmountInfo);
        if (!resultOfStore) {
            throw new NotSavedSalesAmountInfoException(format("sales info was not saved, salesAmountInfo:[%s]", salesAmountInfo));
        }
    }

    @Override
    public synchronized void removeOlderRecords() {
        long second = 60L;
        final LocalDateTime olderTime = timeService.now().minusSeconds(second);
        final List<SalesAmountInfo> allRecords = dataRepository.findAll();
        final List<SalesAmountInfo> olderRecords = allRecords.parallelStream()
                .filter(r -> r.getDateTime().isBefore(olderTime))
                .collect(Collectors.toUnmodifiableList());
        if (!olderRecords.isEmpty()) {
            LOG.debug("In removeOlderRecords - remove records older then 60 seconds, {}", olderRecords);
            dataRepository.removeAll(olderRecords);
        }
    }

    @Override
    public StatisticInfo getStatistic() {
        LOG.debug("In getStatistic - retrieve statistic info");
        final List<SalesAmountInfo> allRecords = List.copyOf(dataRepository.findAll());
        final double average = allRecords.parallelStream()
                .mapToDouble(SalesAmountInfo::getSalesAmount)
                .average()
                .orElse(0.0);
        final double sum = allRecords.parallelStream()
                .mapToDouble(SalesAmountInfo::getSalesAmount)
                .sum();
        return new StatisticInfo(sum, average);
    }

    private void setTimeOfSale(SalesAmountInfo salesAmountInfo) {
        final LocalDateTime currentTime = timeService.now();
        salesAmountInfo.setDateTime(currentTime);
    }

}
