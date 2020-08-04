/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pago.chinchin.Crypto.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amarciales
 */
@Entity
@Table(name = "crypto_table_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CryptoTableMaster.findAll", query = "SELECT c FROM CryptoTableMaster c")
    , @NamedQuery(name = "CryptoTableMaster.findById", query = "SELECT c FROM CryptoTableMaster c WHERE c.id = :id")
    , @NamedQuery(name = "CryptoTableMaster.findByCurrency", query = "SELECT c FROM CryptoTableMaster c WHERE c.currency = :currency")
    , @NamedQuery(name = "CryptoTableMaster.findByCountUnit", query = "SELECT c FROM CryptoTableMaster c WHERE c.countUnit = :countUnit")
    , @NamedQuery(name = "CryptoTableMaster.findByUsd", query = "SELECT c FROM CryptoTableMaster c WHERE c.usd = :usd")})
public class CryptoTableMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "currency")
    private String currency;
    @Column(name = "count_unit")
    private Integer countUnit;
    @Column(name = "usd")
    private Integer usd;

    public CryptoTableMaster() {
    }

    public CryptoTableMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getCountUnit() {
        return countUnit;
    }

    public void setCountUnit(Integer countUnit) {
        this.countUnit = countUnit;
    }

    public Integer getUsd() {
        return usd;
    }

    public void setUsd(Integer usd) {
        this.usd = usd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CryptoTableMaster)) {
            return false;
        }
        CryptoTableMaster other = (CryptoTableMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pago.chinchin.Crypto.entity.CryptoTableMaster[ id=" + id + " ]";
    }
    
}
