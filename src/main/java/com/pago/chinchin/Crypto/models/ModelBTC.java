/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pago.chinchin.Crypto.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.math.BigDecimal;


/**
 *
 * @author amarciales
 */
public class ModelBTC {
    private String USD;
    private String BTC;

    public ModelBTC() {
    }

    public ModelBTC(double USD, double BTC) {
        this.USD = BigDecimal.valueOf(USD).toPlainString();
        this.BTC = BigDecimal.valueOf(BTC).toPlainString();
    }

    public String getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = BigDecimal.valueOf(USD).toPlainString();
    }

    public String getBTC() {
        return BTC;
    }

    public void setBTC(double BTC) {
        this.BTC = BigDecimal.valueOf(BTC).toPlainString();
    }
    
}
