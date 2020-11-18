package com.afniko.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SalesAmountInfoDto {

    @JsonProperty("sales_amount")
    private Double salesAmount;

    public SalesAmountInfoDto() {
    }

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
