package com.afniko.core.repository.impl;

import com.afniko.core.model.SalesAmountInfo;
import com.afniko.core.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class DataRepositoryImpl implements DataRepository {

    private static final Logger LOG = LoggerFactory.getLogger(DataRepositoryImpl.class);

    private List<SalesAmountInfo> amountInfoList = Collections.synchronizedList(new LinkedList<>());

    @Override
    public synchronized boolean save(SalesAmountInfo salesAmountInfo) {
        LOG.debug("In save - saved info into storage");
        return amountInfoList.add(salesAmountInfo);
    }

    @Override
    public synchronized List<SalesAmountInfo> findAll() {
        LOG.debug("In findAll - return all records");
        return amountInfoList;
    }

    @Override
    public synchronized void removeAll(List<SalesAmountInfo> olderRecords) {
        LOG.debug("In removeAll - remove all older records");
        amountInfoList.removeAll(olderRecords);
    }
}
