/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciaProcessoCompra.DAO;

import gerenciaProcessoCompra.model.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Frede
 */
public class DAO<VO> {

    private Session s;
    private Transaction t;
    private Class<VO> classe;

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

    public VO getById(int id){
        return s.get(classe, id);
    }
    
}
