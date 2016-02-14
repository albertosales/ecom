/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalizaCompra;

import gerenciaProcessoCompra.model.HibernateUtil;
import nucleoEcommerce.vo.Produto;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Frede
 */
public class PagamentoCartao {

    private static Session s;
    private static Transaction t;

    public static void main(String[] args) {
        Produto produto = new Produto();
        s = HibernateUtil.getSession().openSession();
        /*t = s.beginTransaction();
        s.merge(produto);
        t.commit();
        s.clear();*/
    }
}
