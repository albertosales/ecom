/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.pagamento;

import br.com.sales.compra.DAO.EstoqueDAO;
import br.com.sales.dao.vo.EstoqueVO;
import br.com.sales.dao.vo.ProdutoVO;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Frede
 */
@ManagedBean
@SessionScoped
public class Estoque {
    
    private int quantidadeCompra;

    public int getQuantidadeCompra() {
        return quantidadeCompra;
    }

    public void setQuantidadeCompra(int quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    }
    
    public void adicionarEstoque(ProdutoVO produto) {
        EstoqueVO estoque = new EstoqueVO();
        estoque.setCompra(quantidadeCompra);
        estoque.setProduto(produto);
        estoque.setData(new Date());
        EstoqueDAO.getInstance().save(estoque);
    }

    public void retirarEstoque() {

    }

   

}
