/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.currency.conversion.service;

import java.math.*;

/**
 *
 * @author PC
 */
public class CurrencyConversion {
    
    private long id;
    private String from;
    private String to;
    private BigDecimal quantity; 
    private BigDecimal conversionMultiple;   
    private BigDecimal totalCalulatedAmount;
    private String environment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal ConversionMultiple) {
        this.conversionMultiple = ConversionMultiple;
    }

    public BigDecimal getTotalCalulatedAmount() {
        return totalCalulatedAmount;
    }

    public void setTotalCalulatedAmount(BigDecimal totalCalulatedAmount) {
        this.totalCalulatedAmount = totalCalulatedAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public CurrencyConversion() {
    }

    public CurrencyConversion(long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity, BigDecimal totalCalulatedAmount, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;       
        this.totalCalulatedAmount = totalCalulatedAmount;
        this.environment = environment;
    }
    
    
}
