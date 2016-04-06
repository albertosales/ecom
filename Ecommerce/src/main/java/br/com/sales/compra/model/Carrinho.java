/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.model;

import java.util.ArrayList;
import br.com.sales.dao.vo.ItemProduto;

/**
 *
 * @author Leandro Klein
 */

public class Carrinho implements br.com.sales.interfaces.ICarrinho{
    
    private ArrayList<ItemProduto> listaDeProdutos;

    public ArrayList<ItemProduto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(ArrayList<ItemProduto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    @Override
    public void adicionaAoCarrinho(ItemProduto itemProduto) {
        listaDeProdutos.add(itemProduto);
    }

    public double getPrecoTotal() {
        double precoTotal = 0.0;
        for(ItemProduto produto : listaDeProdutos){
            precoTotal += produto.getProduto().getPreco();
        }
        return precoTotal;
    }

    public int getQuantidade(){
        int qnt = 0;
        for(ItemProduto produto : listaDeProdutos){
            qnt += produto.getQuantidade();
        }
        return qnt;
    }
}
