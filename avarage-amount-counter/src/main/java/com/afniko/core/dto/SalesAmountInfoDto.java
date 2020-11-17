package com.afniko.core.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SalesAmountInfoDto {

    private Double salesAmount;

    public Double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Double salesAmount) {
        this.salesAmount = salesAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("salesAmount", salesAmount)
                .toString();
    }
}
