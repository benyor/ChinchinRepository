/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pago.chinchin.Crypto.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;

/**
 *
 * @author Luis Nieto
 */
public class BeanUnitModelBS implements Serializable{
    private double dolartoday_BS;
    private double USD=1;

    public BeanUnitModelBS() {
    }

    public BeanUnitModelBS(double dolartoday_BS) {
        this.dolartoday_BS = dolartoday_BS;
    }

    @JsonGetter("dolartoday")
    public double getDolartoday_BS() {
        return dolartoday_BS;
    }

    @JsonSetter("dolartoday")
    public void setDolartoday_BS(double dolartoday_BS) {
        this.dolartoday_BS = dolartoday_BS;
    }

    //@JsonGetter("bs")
    public double getUSD() {
        return USD;
    }

    //@JsonSetter("bs")
    public void setUSD(double USD) {
        this.USD = USD;
    }

    
    
}
