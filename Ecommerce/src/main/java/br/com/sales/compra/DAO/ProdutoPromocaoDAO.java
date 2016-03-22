/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.DAO;

import br.com.sales.dao.vo.ProdutoPromocao;
import br.com.sales.dao.vo.ProdutoVO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ProdutoPromocaoDAO extends DAO<ProdutoPromocao>{

    private static ProdutoPromocaoDAO dao;

    public ProdutoPromocaoDAO(Class<ProdutoPromocao> classe) { 
        super(classe);
    }

    public static ProdutoPromocaoDAO getInstance() {
        if (dao == null) {
            dao = new ProdutoPromocaoDAO(ProdutoPromocao.class);
        }
        return dao;
    }

    public List<ProdutoVO> get(Date inicio, Date fim) {
        String hql = "FROM ProdutoVO WHERE promocao = true";
        return getInstance().getSession().createQuery(hql).list();
    }

}

