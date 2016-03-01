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
public class EstoqueDAO extends DAO<Estoque>{
    
    public EstoqueDAO(Class<Estoque> classe) {
        super(classe);
    }

    public List<Estoque> getEstoquePorPeriodo(Date inicio, Date fim){
        String hql = "";
        
        return null;
    } 
    
}
