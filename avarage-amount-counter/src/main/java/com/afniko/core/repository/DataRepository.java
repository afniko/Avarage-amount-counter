package com.afniko.core.repository;

import com.afniko.core.model.SalesAmountInfo;

import java.util.List;

public interface DataRepository {

    boolean save(SalesAmountInfo salesAmountInfo);

    List<SalesAmountInfo> findAll();

    void removeAll(List<SalesAmountInfo> olderRecords);
}
