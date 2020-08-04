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
public class ModelDASH {
    private String USD;
    private String DASH;

    public ModelDASH() {
    }

    public ModelDASH(double USD, double DASH) {
        this.USD = BigDecimal.valueOf(USD).toPlainString();
        this.DASH = BigDecimal.valueOf(DASH).toPlainString();
    }
    
    public String getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = BigDecimal.valueOf(USD).toPlainString();
    }

    public String getDASH() {
        return DASH;
    }

    public void setDASH(double DASH) {
        this.DASH = BigDecimal.valueOf(DASH).toPlainString();
    }
    
}
