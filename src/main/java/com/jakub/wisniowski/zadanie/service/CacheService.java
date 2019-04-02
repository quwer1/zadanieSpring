package com.jakub.wisniowski.zadanie.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CacheService {
    private Map<String, Rate> currency = new HashMap<>();

    public void fillCurrency(List<Rate> rates) {
        currency.clear();
        for (Rate rate : rates) {
            currency.put(rate.getCurrencyCode(), rate);
        }
    }

    public BigDecimal rateForCurrency(String currencyCode) {
        return currency.get(currencyCode).getCurrencyRate();

    }


}
