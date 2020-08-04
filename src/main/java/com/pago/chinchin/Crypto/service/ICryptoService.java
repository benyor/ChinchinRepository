/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pago.chinchin.Crypto.service;

import com.pago.chinchin.Crypto.entity.CryptoTableMaster;
import java.util.Optional;

/**
 *
 * @author amarciales
 */
public interface ICryptoService {
    
    public Optional<CryptoTableMaster> GetDetails(String currency_name);
    
    public void UpdatePTR(int usd);
    
    public void UpdateBS(int count_unit);
}
