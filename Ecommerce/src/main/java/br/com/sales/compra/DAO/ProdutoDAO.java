/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.DAO;

import java.util.Date;
import java.util.List;
import br.com.sales.dao.vo.EstoqueVO;
import br.com.sales.dao.vo.Produto;

/**
 *
 * @author Frede
 */
public class ProdutoDAO extends DAO<Produto> {

    private static ProdutoDAO dao;

    public ProdutoDAO(Class<Produto> classe) {
        super(classe);
    }

    public static ProdutoDAO getInstance() {
        if (dao == null) {
            dao = new ProdutoDAO(Produto.class);
        }
        return dao;
    }

    public List<EstoqueVO> getEstoquePorPeriodo(Date inicio, Date fim) {
        String hql = "";

        return null;
    }

}
