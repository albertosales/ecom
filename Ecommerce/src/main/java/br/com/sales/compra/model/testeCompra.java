/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.model;

import br.com.sales.compra.DAO.NotaFiscalCompraDAO;
import br.com.sales.compra.controller.NotaFiscalCompraService;
import br.com.sales.dao.vo.ItemCompra;
import br.com.sales.dao.vo.NotaFiscalCompra;

/**
 *
 * @author MarcosAntonio
 */
public class testeCompra {
    public static void main(String[] args) {
        NotaFiscalCompraService nfs = new NotaFiscalCompraService();
        NotaFiscalCompra nc = new NotaFiscalCompra();
        nc.setFornecedor("fornecendo");
        nfs.persistNota(nc);
        System.out.println("A Compra tem: " + nc );
    }
    
    
}
