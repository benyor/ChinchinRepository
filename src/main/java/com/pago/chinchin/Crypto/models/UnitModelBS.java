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
public class UnitModelBS {
    private BeanUnitModelBS USD;

    public UnitModelBS() {
    }

    public UnitModelBS(BeanUnitModelBS USD) {
        this.USD = USD;
    }

    @JsonGetter("USD")
    public BeanUnitModelBS getUSD() {
        return USD;
    }

    public void setUSD(BeanUnitModelBS USD) {
        this.USD = USD;
    }

    
}
