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
public class ModelPTR_Primary {
    private BeanPTR_Primary PTR;

    public ModelPTR_Primary() {
    }

    public ModelPTR_Primary(BeanPTR_Primary PTR) {
        this.PTR = PTR;
    }

    @JsonGetter("PTR")
    public BeanPTR_Primary getPTR() {
        return PTR;
    }

    public void setPTR(BeanPTR_Primary PTR) {
        this.PTR = PTR;
    }

    
}
