package com.afniko.core.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

public class SalesAmountInfo {

    private Double salesAmount;

    private LocalDateTime dateTime;

    public Double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("salesAmount", salesAmount)
                .append("dateTime", dateTime)
                .toString();
    }
}
