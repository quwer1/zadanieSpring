package com.jakub.wisniowski.zadanie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@Service
public class NBPService {

    private final static String DOMESTIC_CURRENCY = "PLN";

    @Autowired
    private CacheService cacheService;

    @Autowired
    private NBPApiService nbbApiService;


    private boolean validCurrency(String currencyGiven, String currencyResult) {
        String currencyToValidate = null;
        if (currencyResult.equals(DOMESTIC_CURRENCY)) {
            currencyToValidate = currencyGiven;
        } else if (!currencyResult.equals(DOMESTIC_CURRENCY)) {
            currencyToValidate = currencyResult;
        }
        List<Rate> currency = nbbApiService.invokeApi();
        String finalCurrencyToValidate = currencyToValidate;
        return currency.stream().filter(o -> o.getCurrencyCode().equals(finalCurrencyToValidate)).findFirst().isPresent();
    }


    public BigDecimal getAmountInGivenCurrency(BigDecimal amountGiven, String currencyGiven, String currencyResult) {
        BigDecimal result;

        if (validCurrency(currencyGiven, currencyResult) != true) {
            throw new IllegalArgumentException("operation code not supported");
        }

        if (currencyGiven.equals("PLN")) {
            BigDecimal currency = cacheService.rateForCurrency(currencyResult);
            result = amountGiven.divide(currency, 4, RoundingMode.HALF_UP);
        } else {
            BigDecimal currency = cacheService.rateForCurrency(currencyGiven);
            result = currency.multiply(amountGiven).setScale(4, RoundingMode.UP);
        }

        return result;

    }

}
