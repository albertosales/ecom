/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciaProcessoCompra.model;

import gerenciaProcessoCompra.DAO.EstoqueDAO;
import gerenciaProcessoCompra.DAO.ProdutoDAO;
import nucleoEcommerce.vo.Estoque;
import nucleoEcommerce.vo.Produto;

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
