package com.jakub.wisniowski.zadanie.service;

import java.math.BigDecimal;

public class Rate {

    private String currencyCode;
    private BigDecimal currencyRate;


    public Rate(String currencyCode, BigDecimal currencyRate) {
        this.currencyCode = currencyCode;
        this.currencyRate = currencyRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
    }


}
