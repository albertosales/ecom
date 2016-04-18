/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.DAO;

import br.com.sales.dao.vo.NotaFiscalCompra;

/**
 *
 * @author MarcosAntonio
 */
public class NotaFiscalCompraDAO extends DAO<NotaFiscalCompra>{
    private static NotaFiscalCompraDAO dao;
    
    public NotaFiscalCompraDAO(Class<NotaFiscalCompra> classe) {
        super(classe);
    }
    
    public static NotaFiscalCompraDAO getInstance() {
        if(dao == null) {
            dao = new NotaFiscalCompraDAO(NotaFiscalCompra.class);
        }
        return dao;
    }
}
