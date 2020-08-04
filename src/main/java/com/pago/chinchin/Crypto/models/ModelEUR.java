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
public class ModelEUR {
    private String USD;
    private String EUR;

    public ModelEUR() {
    }

    public ModelEUR(double USD, double EUR) {
        this.USD = BigDecimal.valueOf(USD).toPlainString();
        this.EUR = BigDecimal.valueOf(EUR).toPlainString();
    }

    public String getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = BigDecimal.valueOf(USD).toPlainString();
    }

    public String getEUR() {
        return EUR;
    }

    public void setEUR(double EUR) {
        this.EUR = BigDecimal.valueOf(EUR).toPlainString();
    }
    
}
