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
public class ModelPTR {
    private String USD;
    private String PTR;

    public ModelPTR() {
    }

    public ModelPTR(double USD, double PTR) {
        this.USD = BigDecimal.valueOf(USD).toPlainString();
        this.PTR = BigDecimal.valueOf(PTR).toPlainString();
    }

    public String getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = BigDecimal.valueOf(USD).toPlainString();
    }

    public String getPTR() {
        return PTR;
    }

    public void setPTR(double PTR) {
        this.PTR = BigDecimal.valueOf(PTR).toPlainString();
    }
    
}
