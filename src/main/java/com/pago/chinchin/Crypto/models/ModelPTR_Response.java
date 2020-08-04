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
public class ModelPTR_Response {
    ModelPTR_Primary data;

    public ModelPTR_Response() {
    }
    
    public ModelPTR_Response(ModelPTR_Primary data) {
        this.data = data;
    }

    @JsonGetter("data")
    public ModelPTR_Primary getData() {
        return data;
    }

    public void setData(ModelPTR_Primary data) {
        this.data = data;
    }
    
    
}
