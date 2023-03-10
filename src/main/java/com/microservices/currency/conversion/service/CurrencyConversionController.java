/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.currency.conversion.service;

import java.math.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

/**
 *
 * @author PC
 */
@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
            @PathVariable BigDecimal quantity) {
        
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,
                uriVariables);

        CurrencyConversion response = responseEntity.getBody();

        return new CurrencyConversion(response.getId(),
                from, to,
                quantity,                
                response.getConversionMultiple(),
                quantity.multiply(response.getConversionMultiple()),
                response.getEnvironment()+ " REST");
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
            @PathVariable BigDecimal quantity) {

        CurrencyConversion response = proxy.retrieveExchangeValue(from, to);

        return new CurrencyConversion(response.getId(), from, to, quantity, response.getConversionMultiple(), 
                quantity.multiply(response.getConversionMultiple()), response.getEnvironment() + " Feign");
    }
    
    
}
