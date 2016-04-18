/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.dao.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author MarcosAntonio
 */
@Entity
public class Compra implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.REFRESH})
    private Item item;
    private int numNotaFiscal;
    private float valorNotaFiscal;
    private String fornecedor;

    public Compra() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNumNotaFiscal() {
        return numNotaFiscal;
    }

    public void setNumNotaFiscal(int numNotaFiscal) {
        this.numNotaFiscal = numNotaFiscal;
    }

    public float getValorNotaFiscal() {
        return valorNotaFiscal;
    }

    public void setValorNotaFiscal(float valorNotaFiscal) {
        this.valorNotaFiscal = valorNotaFiscal;
    }


    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compra other = (Compra) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
