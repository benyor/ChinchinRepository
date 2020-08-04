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
public class ModelETH {
    private String USD;
    private String ETH;

    public ModelETH() {
    }

    public ModelETH(double USD, double ETH) {
        this.USD = BigDecimal.valueOf(USD).toPlainString();
        this.ETH = BigDecimal.valueOf(ETH).toPlainString();
    }

    public String getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = BigDecimal.valueOf(USD).toPlainString();
    }

    public String getETH() {
        return ETH;
    }

    public void setETH(double ETH) {
        this.ETH = BigDecimal.valueOf(ETH).toPlainString();
    }
    
}
