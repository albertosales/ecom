/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.DAO;

import br.com.sales.compra.model.HibernateUtil;
import br.com.sales.dao.vo.ItemCompra;
import br.com.sales.dao.vo.NotaFiscalCompra;
import br.com.sales.dao.vo.ProdutoVO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Frede
 */
public class DAO<VO> {

    private Session s;
    private Transaction t;
    private Class<VO> classe;
    private static NotaFiscalCompra nfc;

    public DAO(Class<VO> classe) {
        this.classe = classe;
        s = HibernateUtil.getSession().openSession();
    }

    public Session getSession() {
        return s;
    }

    public void save(VO vo) {
        t = s.beginTransaction();
        s.merge(vo);
        t.commit();
    }

    public void delete(VO vo) {
        t = s.beginTransaction();
        s.delete(vo);
        t.commit();
    }

    public void update(VO vo) {
        t = s.beginTransaction();
        s.update(vo);
        t.commit();
    }

    public void saveOrUpdate(VO vo) {
        t = s.beginTransaction();
        s.saveOrUpdate(vo);
        t.commit();
    }

    public List<VO> getAll() {
        return (List<VO>) s.createCriteria(classe).list();
    }

    public VO getById(int id) {
        return s.get(classe, id);
    }

    public VO setById(String mome) {
        return (VO) s.save(mome);
    }

    public VO getId(VO vo) {
        Criteria criteria = s.createCriteria(classe);
        ProdutoVO id = (ProdutoVO) criteria.setProjection(Projections.id()).uniqueResult();
        return (VO) id;
    }

    /**
     * public void setById(int id) { nfc.setId(id); }
     */
    public int getMaxNotaId(VO vo) {
        Criteria criteria = s.createCriteria(classe);
        int maxId = (int) criteria.setProjection(Projections.max("id")).uniqueResult();
        return maxId;
    }

    public VO getNumNotaFiscal(int numNotaFiscal) {
        return s.get(classe, numNotaFiscal);
    }
    
   
}
