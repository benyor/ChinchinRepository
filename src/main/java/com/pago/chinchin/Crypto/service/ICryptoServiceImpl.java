/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pago.chinchin.Crypto.service;

import com.pago.chinchin.Crypto.daos.ICryptoDao;
import com.pago.chinchin.Crypto.entity.CryptoTableMaster;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amarciales
 */
@Service
public class ICryptoServiceImpl implements ICryptoService{

    @Autowired
    ICryptoDao ICD;
    
    @Override
    @Transactional
    public Optional<CryptoTableMaster> GetDetails(String currency_name) {
        return ICD.FindCryptoByCurrency(currency_name);
    }

    @Override
    @Transactional
    public void UpdatePTR(int usd) {
        ICD.UpdatePTR(usd, "PTR");
    }

    @Override
    @Transactional
    public void UpdateBS(int count_unit) {
        ICD.UpdateBS(count_unit, "BS");
    }
    
}
