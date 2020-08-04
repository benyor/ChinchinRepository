/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pago.chinchin.Crypto.daos;

import com.pago.chinchin.Crypto.entity.CryptoTableMaster;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amarciales
 */
@Repository
@Transactional
public interface ICryptoDao extends JpaRepository<CryptoTableMaster, Integer>{
    @Query("select ctm from CryptoTableMaster ctm where ctm.currency = ?1")
    Optional<CryptoTableMaster> FindCryptoByCurrency(String currency_name);
    
    @Modifying
    @Query("update CryptoTableMaster ctm set ctm.usd= ?1 where ctm.currency = ?2")
    void UpdatePTR(int Count_USD,String currency_name);
    
    @Modifying
    @Query("update CryptoTableMaster ctm set ctm.countUnit= ?1 where ctm.currency = ?2")
    void UpdateBS(int Count_Units,String currency_name);
}
