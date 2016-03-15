/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciaProcessoCompra.model;

import java.util.ArrayList;
import nucleoEcommerce.vo.ItemProduto;

/**
 *
 * @author Leandro Klein
 */

public class Carrinho implements nucleoEcommerce.interfaces.ICarrinho{
    
    private ArrayList<ItemProduto> listaDeProdutos;

    public ArrayList<ItemProduto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(ArrayList<ItemProduto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    @Override
    public void adicionaAoCarrinho(ItemProduto produto) {
        listaDeProdutos.add(produto);
    }

    public double getPrecoTotal() {
        double total = 0.0;
        for(ItemProduto itemProduto : listaDeProdutos){
            total = itemProduto.getQtde() * itemProduto.getProduto().getPreco();
        }
        return total;
    }
   
}
