/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pago.chinchin.Crypto.models;

/**
 *
 * @author amarciales
 */
public class CryptoResponseDataModelBS {
    private ModelBTC conversion_BTC;
    private ModelETH conversion_ETH;
    private ModelDASH conversion_DASH;
    private ModelPTR conversion_PTR;
    private ModelEUR conversion_EUR;

    public CryptoResponseDataModelBS() {
    }

    public CryptoResponseDataModelBS(ModelBTC conversion_BTC, ModelETH conversion_ETH, ModelDASH conversion_DASH, ModelPTR conversion_PTR, ModelEUR conversion_EUR) {
        this.conversion_BTC = conversion_BTC;
        this.conversion_ETH = conversion_ETH;
        this.conversion_DASH = conversion_DASH;
        this.conversion_PTR = conversion_PTR;
        this.conversion_EUR = conversion_EUR;
    }

    public ModelBTC getConversion_BTC() {
        return conversion_BTC;
    }

    public void setConversion_BTC(ModelBTC conversion_BTC) {
        this.conversion_BTC = conversion_BTC;
    }

    public ModelETH getConversion_ETH() {
        return conversion_ETH;
    }

    public void setConversion_ETH(ModelETH conversion_ETH) {
        this.conversion_ETH = conversion_ETH;
    }

    public ModelDASH getConversion_DASH() {
        return conversion_DASH;
    }

    public void setConversion_DASH(ModelDASH conversion_DASH) {
        this.conversion_DASH = conversion_DASH;
    }

    public ModelPTR getConversion_PTR() {
        return conversion_PTR;
    }

    public void setConversion_PTR(ModelPTR conversion_PTR) {
        this.conversion_PTR = conversion_PTR;
    }

    public ModelEUR getConversion_EUR() {
        return conversion_EUR;
    }

    public void setConversion_EUR(ModelEUR conversion_EUR) {
        this.conversion_EUR = conversion_EUR;
    }

    
    
}
