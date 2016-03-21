/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.DAO;

import br.com.sales.dao.vo.ProdutoVO;

/**
 *
 * @author MarcosAntonio
 */
public class ProdutoVoDAO extends DAO<ProdutoVO>{
    private static ProdutoVoDAO dao;
    
    public ProdutoVoDAO(Class<ProdutoVO> classe) {
        super(classe);
    }
    
    public static ProdutoVoDAO getInstance() {
        if(dao == null) {
            dao = new ProdutoVoDAO(ProdutoVO.class);
        }
        return dao;
    }

}
