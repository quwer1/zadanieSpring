package com.jakub.wisniowski.zadanie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class ScheduleService {

    @Autowired
    private NBPApiService nbpApiService;

    @Autowired
    private CacheService cacheService;

    private static final Logger LOGGER = Logger.getLogger(ScheduleService.class.getName());

    @Scheduled(cron = "0 15 10 15 * ?")
    public void refreshCache() {
        LOGGER.info("update  data download fx rates from NBP at " + System.currentTimeMillis());
        List<Rate> rates = nbpApiService.invokeApi();
        cacheService.fillCurrency(rates);
    }
}
