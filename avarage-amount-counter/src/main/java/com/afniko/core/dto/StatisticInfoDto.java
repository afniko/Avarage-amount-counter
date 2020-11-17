package com.afniko.core.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class StatisticInfoDto {

    private Double totalSalesAmount;

    private Double averageAmountPerOrder;

    public Double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(Double totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    public Double getAverageAmountPerOrder() {
        return averageAmountPerOrder;
    }

    public void setAverageAmountPerOrder(Double averageAmountPerOrder) {
        this.averageAmountPerOrder = averageAmountPerOrder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("totalSalesAmount", totalSalesAmount)
                .append("averageAmountPerOrder", averageAmountPerOrder)
                .toString();
    }
}
