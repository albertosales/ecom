/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.DAO;

import java.util.Date;
import java.util.List;
import br.com.sales.dao.vo.Estoque;
import br.com.sales.dao.vo.ProdutoVO;

/**
 *
 * @author Frede
 */
public class ProdutoDAO extends DAO<ProdutoVO> {

    private static ProdutoDAO dao;

    public ProdutoDAO(Class<ProdutoVO> classe) {
        super(classe);
    }

    public static ProdutoDAO getInstance() {
        if (dao == null) {
            dao = new ProdutoDAO(ProdutoVO.class);
        }
        return dao;
    }

    public List<Estoque> getEstoquePorPeriodo(Date inicio, Date fim) {
        String hql = "";

        return null;
    }

}
