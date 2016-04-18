/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.DAO;

import br.com.sales.dao.vo.ItemCompra;

/**
 *
 * @author MarcosAntonio
 */
public class ItemCompraDAO extends DAO<ItemCompra>{
    private static ItemCompraDAO dao;
    
    public ItemCompraDAO(Class<ItemCompra> classe) {
        super(classe);
    }
    
    public static ItemCompraDAO getInstance() {
        if(dao == null) {
            dao = new ItemCompraDAO(ItemCompra.class);
        }
        return dao;
    }
}
