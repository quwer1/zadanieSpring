package com.jakub.wisniowski.zadanie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.Logger;

@Component
public class InitRates {
    @Autowired
    private NBPApiService nbpApiService;

    @Autowired
    private CacheService cacheService;

    private static final Logger LOGGER = Logger.getLogger(InitRates.class.getName());

    @PostConstruct
    public void init() {
        List<Rate> rates = nbpApiService.invokeApi();
        cacheService.fillCurrency(rates);
        LOGGER.info("init data download fx rates from NBP");
    }
}