/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pago.chinchin.Crypto.models;

import java.io.Serializable;

/**
 *
 * @author amarciales
 */
public class ResponseMDPGeneric implements Serializable{
    
    private int StatusCode;
    
    private String StatusCodeDescription;

    public ResponseMDPGeneric() {
    }

    public ResponseMDPGeneric(int StatusCode, String StatusCodeDescription) {
        this.StatusCode = StatusCode;
        this.StatusCodeDescription = StatusCodeDescription;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getStatusCodeDescription() {
        return StatusCodeDescription;
    }

    public void setStatusCodeDescription(String StatusCodeDescription) {
        this.StatusCodeDescription = StatusCodeDescription;
    }

    
}
