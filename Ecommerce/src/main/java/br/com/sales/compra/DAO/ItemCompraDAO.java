/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.DAO;

import br.com.sales.compra.model.HibernateUtil;
import br.com.sales.dao.vo.ItemCompra;
import java.util.List;

/**
 *
 * @author MarcosAntonio
 */
public class ItemCompraDAO extends DAO<ItemCompra> {

    private static ItemCompraDAO dao;

    public ItemCompraDAO(Class<ItemCompra> classe) {
        super(classe);
    }

    public static ItemCompraDAO getInstance() {
        if (dao == null) {
            dao = new ItemCompraDAO(ItemCompra.class);
        }
        return dao;
    }

    public List<ItemCompra> getListaItensCompra(int id) {
        String hql = "FROM ItemCompra";      // WHERE notaFiscalCompra.numNotaFiscal= :id ";
        return getInstance().getSession().createQuery(hql).list();
    }

    public Object getProdutovo() {
        String hql = "INSERT INTO ecom.ItemCompra (descricaoProduto, valorUnitario)\n"
                + "SELECT nome, preco FROM ecom.produtovo";
        
        return getInstance().getSession().createSQLQuery(hql).uniqueResult();
    }
}
