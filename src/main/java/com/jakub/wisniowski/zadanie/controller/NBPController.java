package com.jakub.wisniowski.zadanie.controller;

import com.jakub.wisniowski.zadanie.service.NBPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.logging.Logger;

@RestController
public class NBPController {

    @Autowired
    private NBPService nbpService;

    private static final Logger LOGGER = Logger.getLogger(NBPController.class.getName());

    @GetMapping(value = "/rate")
    public @ResponseBody
    Double getCurrency(
            @RequestParam("amountGiven") BigDecimal amountGiven,
            @RequestParam("currencyGiven") String currencyGiven,
            @RequestParam("currencyResult") String currencyResult) {


        LOGGER.info("currency start conversion" + " amount " + amountGiven + " " + currencyGiven + " to" + currencyResult);

        return nbpService.getAmountInGivenCurrency(amountGiven, currencyGiven, currencyResult);
    }

}

