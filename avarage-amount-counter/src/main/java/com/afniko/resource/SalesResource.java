package com.afniko.resource;

import com.afniko.core.dto.SalesAmountInfoDto;
import com.afniko.core.model.SalesAmountInfo;
import com.afniko.core.parser.FlexibleSalesAmountInfoDtoParser;
import com.afniko.core.service.DataSalesService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.afniko.core.constants.Constants.Endpoints;

@RestController
@RequestMapping(Endpoints.SALES)
public class SalesResource {

    private static final Logger LOG = LoggerFactory.getLogger(SalesResource.class);

    private final DataSalesService dataSalesService;

    private final FlexibleSalesAmountInfoDtoParser parser;

    private final ModelMapper mapper;

    public SalesResource(DataSalesService dataSalesService,
                         FlexibleSalesAmountInfoDtoParser parser,
                         ModelMapper mapper) {
        this.dataSalesService = dataSalesService;
        this.parser = parser;
        this.mapper = mapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void getSalesInfo(@RequestParam MultiValueMap<String, String> paramMap) {
        LOG.debug("In getSalesInfo - received POST request with info about sales:[{}]", paramMap);
        SalesAmountInfoDto dto = parser.parse(paramMap);
        final SalesAmountInfo salesAmountInfo = mapper.map(dto, SalesAmountInfo.class);
        dataSalesService.save(salesAmountInfo);
    }
}
