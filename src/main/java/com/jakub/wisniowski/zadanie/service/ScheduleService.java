package com.jakub.wisniowski.zadanie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleService {

    @Autowired
    private NBPApiService nbpApiService;

    @Autowired
    private CacheService cacheService;

    @Scheduled(cron = "0 15 10 15 * ?")
    public void refreshCache() {
        List<Rate> rates = nbpApiService.invokeApi();
        cacheService.fillCurrency(rates);


    }


}
