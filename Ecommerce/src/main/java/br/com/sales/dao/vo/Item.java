/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.dao.vo;

import java.io.Serializable;

/**
 *
 * @author alberto
 */
public class Item implements Serializable {
    private ProdutoVO prod;
//    private ProdutoPromocao prodProm;
    private int qtde;

 /*   public ProdutoPromocao getProdProm() {
        return prodProm;
    }

    public void setProdProm(ProdutoPromocao prodProm) {
        this.prodProm = prodProm;
    }   */
    
    

    public ProdutoVO getProd() {
        return prod;
    }

    public void setProd(ProdutoVO prod) {
        this.prod = prod;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
}

