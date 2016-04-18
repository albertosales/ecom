/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.DAO;

import java.util.Date;
import java.util.List;
import br.com.sales.dao.vo.EstoqueVO;

/**
 *
 * @author Frede
 */
public class EstoqueDAO extends DAO<EstoqueVO> {

    private static EstoqueDAO dao;

    public EstoqueDAO(Class<EstoqueVO> classe) {
        super(classe);
    }

    public static EstoqueDAO getInstance() {
        if (dao == null) {
            dao = new EstoqueDAO(EstoqueVO.class);
        }
        return dao;
    }

    public long getEstoquePorPeriodo(Date inicio, Date fim, int produtoId) {
        String hql = "SELECT (SUM(compra)-SUM(venda)) FROM EstoqueVO WHERE produto_id = :produtoId AND (data >= :inicio AND data <= :fim)";
        return (long) getInstance().getSession().createQuery(hql).setInteger("produtoId", produtoId).setDate("inicio", inicio).setDate("fim", fim).uniqueResult();
    }

    public long getEstoqueAtual(int produtoId) {
        String hql = "SELECT (SUM(compra)-SUM(venda)) FROM EstoqueVO WHERE produto_id = :produtoId";
        return (long) getInstance().getSession().createQuery(hql).setInteger("produtoId", produtoId).uniqueResult();
    }

    public void saveAll(List<EstoqueVO> estoques){
        for (EstoqueVO estoque : estoques) {
            getInstance().save(estoque);
        }
    }
    
}
