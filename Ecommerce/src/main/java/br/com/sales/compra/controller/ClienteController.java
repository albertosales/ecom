/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.controller;

import br.com.sales.dao.vo.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Leandro Klein
 */
@ManagedBean(name = "cliente")
@SessionScoped
public class ClienteController {
    private Cliente cliente;
    
    public ClienteController(){
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
