/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.currency.conversion.service;

import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author PC
 */

//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeServiceProxy {
    
    	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue
        (@PathVariable("from") String from, @PathVariable("to") String to);
        
}
