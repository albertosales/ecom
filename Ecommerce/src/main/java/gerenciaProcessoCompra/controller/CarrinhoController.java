/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciaProcessoCompra.controller;

import gerenciaProcessoCompra.model.Carrinho;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Leandro Klein
 */
@ManagedBean
@SessionScoped
public class CarrinhoController {
    private Carrinho carrinho;
    
    public CarrinhoController(){
        carrinho = new Carrinho();
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}
