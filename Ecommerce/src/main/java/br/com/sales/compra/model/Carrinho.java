/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.model;

import java.util.ArrayList;
import br.com.sales.dao.vo.Produto;

/**
 *
 * @author Leandro Klein
 */

public class Carrinho implements br.com.sales.interfaces.ICarrinho{
    
    private ArrayList<Produto> listaDeProdutos;

    public ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(ArrayList<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    @Override
    public void adicionaAoCarrinho(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPrecoTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getQuantidade(Produto produto){
        int qnt = 0;
        for (Produto prod : listaDeProdutos) {
            if(prod.getId() == produto.getId()){
                qnt++;
            }
        }
        return qnt;
    }
}
