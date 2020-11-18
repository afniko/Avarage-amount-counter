package com.afniko.core.parser;

import com.afniko.core.dto.SalesAmountInfoDto;
import org.springframework.util.MultiValueMap;

public interface FlexibleSalesAmountInfoDtoParser {

    SalesAmountInfoDto parse(MultiValueMap<String, String> paramMap);

}
