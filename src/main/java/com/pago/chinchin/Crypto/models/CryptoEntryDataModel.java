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
public class CryptoEntryDataModel {
    private BigDecimal mount;
    private String currency;

    public CryptoEntryDataModel() {
    }

    public CryptoEntryDataModel(BigDecimal mount, String currency) {
        this.mount = mount;
        this.currency = currency;
    }

    public BigDecimal getMount() {
        return mount;
    }

    public void setMount(BigDecimal mount) {
        this.mount = mount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
}
