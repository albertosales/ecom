/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.model;

import java.util.ArrayList;
import br.com.sales.dao.vo.ItemProduto;
import br.com.sales.dao.vo.ProdutoVO;
import java.awt.event.ActionEvent;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Request;

/**
 *
 * @author Leandro Klein
 */
public class Carrinho implements br.com.sales.interfaces.ICarrinho {

    private ArrayList<ItemProduto> listaDeProdutos;

    public Carrinho() {
        listaDeProdutos = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            ProdutoVO produto = new ProdutoVO();
            produto.setFoto("images/product/a1.jpg");
            produto.setId(i);
            produto.setNome("Teste produto " + i);
            produto.setPreco((i * 5));
            ItemProduto item = new ItemProduto(i, produto);
            listaDeProdutos.add(item);
        }
    }

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

    public void removerDoCarrinho(int idProduto) {
        for (int i = 0; i < listaDeProdutos.size(); i++) {
            if (listaDeProdutos.get(i).getProduto().getId() == idProduto) {
                listaDeProdutos.remove(listaDeProdutos.get(i));
                --i;
            }
        }
    }
    
    public void atualizarCarrinho(){
        HttpServletRequest request = null ;
        Enumeration paremeterNames = request.getParameterNames();
        while (paremeterNames.hasMoreElements()) {
            String nextElement = (String) paremeterNames.nextElement();
            if(nextElement.contains("qtd")){
                int qtd = Integer.parseInt(request.getParameter(nextElement));
                //Atribuir a nova quantidade ao ItemProduto(Produto produto, quantidade qtd) que está no carrinho.
                
            }
        }
        
    }

    public double getPrecoTotal() {
        double precoTotal = 0.0;
        for (ItemProduto produto : listaDeProdutos) {
            precoTotal += (produto.getProduto().getPreco() * produto.getQuantidade());
        }
        return precoTotal;
    }

    public int getQuantidade() {
        int qnt = 0;
        for (ItemProduto produto : listaDeProdutos) {
            qnt += produto.getQuantidade();
        }
        return qnt;
    }
}
