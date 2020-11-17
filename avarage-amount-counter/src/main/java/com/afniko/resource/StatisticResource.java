package com.afniko.resource;

import com.afniko.core.dto.StatisticInfoDto;
import com.afniko.core.model.StatisticInfo;
import com.afniko.core.service.DataSalesService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.afniko.core.constants.Constants.Endpoints;

@RestController
@RequestMapping(Endpoints.STATISTICS)
public class StatisticResource {
    private static final Logger LOG = LoggerFactory.getLogger(StatisticResource.class);

    private final DataSalesService dataSalesService;

    private final ModelMapper mapper;

    public StatisticResource(DataSalesService dataSalesService, ModelMapper mapper) {
        this.dataSalesService = dataSalesService;
        this.mapper = mapper;
    }

    @GetMapping
    public StatisticInfoDto getStatisticInfo() {
        LOG.debug("In getStatisticInfo - send statistic info");

        StatisticInfo statisticInfo = dataSalesService.getStatistic();
        return mapper.map(statisticInfo, StatisticInfoDto.class);
    }

}
