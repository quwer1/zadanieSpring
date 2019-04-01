package com.jakub.wisniowski.zadanie.controller;

import com.jakub.wisniowski.zadanie.service.Currency;
import com.jakub.wisniowski.zadanie.service.NBPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class NBPController {

    @Autowired
    NBPService nbpService;

    /*@RequestMapping(value = ["/"], method = [RequestMethod.GET])
    @RequestParam("amount", required = true) BigDecimal amountGiven,
    @RequestParam("amount", required = true) BigDecimal amountResult,
    @RequestParam("currency", required = false) Currency currency,

    public CurrencyNbp getCurrency(@PathVariable Integer id) {

        return personService.getPerson(id);
    }*/


}