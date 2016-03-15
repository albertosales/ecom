/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.model;

import br.com.sales.compra.DAO.EstoqueDAO;
import br.com.sales.compra.DAO.ProdutoDAO;
import br.com.sales.dao.vo.Estoque;
import br.com.sales.dao.vo.Produto;

/**
 *
 * @author Frede
 */
public class teste {
    public static void main(String[] args) {
        Estoque vo = new Estoque();
        Produto prod = new Produto();
        prod.setId(0);
        ProdutoDAO.getInstance().save(prod);
        prod.setNome("Teste");
        vo.setProduto(prod);
        vo.setVenda(70);
        EstoqueDAO.getInstance().save(vo);
        
        System.out.println(EstoqueDAO.getInstance().getEstoqueAtual(prod.getId()));
    }
}
