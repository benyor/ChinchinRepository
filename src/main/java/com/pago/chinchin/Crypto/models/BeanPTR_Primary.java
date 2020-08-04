/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pago.chinchin.Crypto.models;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 *
 * @author Luis Nieto
 */
public class BeanPTR_Primary {
    private double USD;

    public BeanPTR_Primary() {
    }

    public BeanPTR_Primary(double USD) {
        this.USD = USD;
    }

    @JsonGetter("USD")
    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

}
