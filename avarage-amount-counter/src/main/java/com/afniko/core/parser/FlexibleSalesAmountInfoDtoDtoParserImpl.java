package com.afniko.core.parser;

import com.afniko.core.dto.SalesAmountInfoDto;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import static java.util.Objects.nonNull;

@Service
public class FlexibleSalesAmountInfoDtoDtoParserImpl implements FlexibleSalesAmountInfoDtoParser {

    public SalesAmountInfoDto parse(MultiValueMap<String, String> paramMap) {
        String salesAmountKey = "sales_amount";
        String doubleString = paramMap.getFirst(salesAmountKey);
        SalesAmountInfoDto dto = new SalesAmountInfoDto();
        if (nonNull(doubleString)) {
            if (doubleString.contains(",")) {
                doubleString = doubleString.replace(",", ".");
            }
            dto.setSalesAmount(Double.valueOf(doubleString));
        }
        return dto;
    }

}
