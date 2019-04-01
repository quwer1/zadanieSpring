package com.jakub.wisniowski.zadanie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class NBPService {

    @Autowired
    private CacheService cacheService;


    public Double getAmountInGivenCurrency(BigDecimal amountGiven, String currencyGiven, String currencyResult) {

        BigDecimal result;


        if (currencyGiven.equals("PLN")) {
            BigDecimal currency = cacheService.rateForCurrency(currencyResult);
            result = amountGiven.divide(currency, 4, RoundingMode.HALF_UP);
        } else {
            BigDecimal currency = cacheService.rateForCurrency(currencyGiven);
            result = currency.multiply(amountGiven).setScale(4, RoundingMode.UP);
        }

        return result.doubleValue();

    }

}
