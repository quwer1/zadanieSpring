package com.jakub.wisniowski.zadanie.service;


import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class NBPApiService {

    private static final String URL = "http://api.nbp.pl/api/exchangerates/tables/A/";

    @Autowired
    private RestTemplate restTemplate;


    public List<Rate> invokeApi() {

        List<Rate> rates = new ArrayList<>();

        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);


        JSONArray obj = new JSONArray(response.getBody());
        JSONArray arrayRate = obj.getJSONObject(0).getJSONArray("rates");

        for (int a = 0; a < arrayRate.length(); a++) {
            String code = arrayRate.getJSONObject(a).getString("code");
            BigDecimal mid = arrayRate.getJSONObject(a).getBigDecimal("mid");

            Rate rate = new Rate(code, mid);
            rates.add(rate);

        }

        return rates;


    }

}
