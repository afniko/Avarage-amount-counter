package com.afniko.core.service;

import com.afniko.core.model.SalesAmountInfo;
import com.afniko.core.model.StatisticInfo;

public interface DataSalesService {

    void save(SalesAmountInfo salesAmountInfo);

    void removeOlderRecords();

    StatisticInfo getStatistic();
}
