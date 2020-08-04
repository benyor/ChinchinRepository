/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pago.chinchin.Crypto.models;

/**
 *
 * @author Luis Nieto
 */
public class ModelPTR_Entry {
    private String[] coins={"PTR"};
    private String[] fiats={"USD"};

    public ModelPTR_Entry() {
    }

    public String[] getCoins() {
        return coins;
    }

    public void setCoins(String[] coins) {
        this.coins = coins;
    }

    public String[] getFiats() {
        return fiats;
    }

    public void setFiats(String[] fiats) {
        this.fiats = fiats;
    }
    
    
}
