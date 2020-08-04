/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pago.chinchin.Crypto.models;

import java.math.BigDecimal;


/**
 *
 * @author amarciales
 */
public class ModelBS {
    private String USD;
    private String BS;

    public ModelBS() {
    }

    public ModelBS(double USD, double BS) {
        this.USD = BigDecimal.valueOf(USD).toPlainString();
        this.BS = BigDecimal.valueOf(BS).toPlainString();
    }

    public String getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = BigDecimal.valueOf(USD).toPlainString();
    }

    public String getBS() {
        return BS;
    }

    public void setBS(double BS) {
        this.BS = BigDecimal.valueOf(BS).toPlainString();
    }
    
    
}
