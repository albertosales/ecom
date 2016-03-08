/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciaProcessoCompra.DAO;

import java.util.Date;
import java.util.List;
import nucleoEcommerce.vo.Estoque;

/**
 *
 * @author Frede
 */
public class EstoqueDAO extends DAO<Estoque> {

    private static EstoqueDAO dao;

    public EstoqueDAO(Class<Estoque> classe) {
        super(classe);
    }

    public static EstoqueDAO getInstance() {
        if (dao == null) {
            dao = new EstoqueDAO(Estoque.class);
        }
        return dao;
    }

    public List<Estoque> getEstoquePorPeriodo(Date inicio, Date fim) {
        String hql = "";

        return null;
    }

    public long getEstoqueAtual(int produtoId) {
        String hql = "SELECT (SUM(compra)-SUM(venda)) FROM Estoque WHERE produto_id = :produtoId";
        return (long) getInstance().getSession().createQuery(hql).setInteger("produtoId", produtoId).uniqueResult();
    }

    public void saveAll(List<Estoque> estoques){
        for (Estoque estoque : estoques) {
            getInstance().save(estoque);
        }
    }
    
}
