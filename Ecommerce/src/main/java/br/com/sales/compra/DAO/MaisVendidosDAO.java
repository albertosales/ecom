/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.DAO;

import br.com.sales.dao.vo.Vendas;
import java.util.Date;
import java.util.List;
import br.com.sales.dao.vo.MaisVendidos;


/**
 *
 * @author aluno
 */
public class MaisVendidosDAO extends DAO<MaisVendidos>  {
 private static MaisVendidosDAO dao;

    public MaisVendidosDAO(Class<MaisVendidos> classe) {
        super(classe);
    }

    public static MaisVendidosDAO getInstance() {
        if (dao == null) {
            dao = new MaisVendidosDAO(MaisVendidos.class);
        }
        return dao;
    }

    public List<Vendas> getEstoquePorPeriodo(Date inicio, Date fim) {
        String hql = "";

        return null;
    }

}
