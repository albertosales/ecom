/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciaProcessoCompra.model;

import java.util.ArrayList;
import nucleoEcommerce.vo.Produto;

/**
 *
 * @author Leandro Klein
 */

public class Carrinho implements nucleoEcommerce.interfaces.ICarrinho{
    
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
}
