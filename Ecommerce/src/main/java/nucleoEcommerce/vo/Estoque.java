/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleoEcommerce.vo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Frede
 */
public class Estoque{

    private int id;
    private Produto produto;
    private int compra, venda;
    private Date data;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public void atualizarEstoqueCompra(List<Produto> produtos){
          this.compra = produtos.size();
    }
    
    public void atualizarEstoqueVenda(List<Produto> produtos){
          this.venda = produtos.size();
        
    }
    
}
