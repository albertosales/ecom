/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.DAO;

import br.com.sales.dao.vo.GrupoProduto;

/**
 *
 * @author MarcosAntonio
 */
public class GrupoProdutoVoDAO extends DAO<GrupoProduto> {
    private static GrupoProdutoVoDAO dao;

    public GrupoProdutoVoDAO(Class<GrupoProduto> classe) {
        super(classe);
    }
    
    public static GrupoProdutoVoDAO getInstance() {
        if (dao == null) {
            dao = new GrupoProdutoVoDAO(GrupoProduto.class);
        }
        return dao;
    }


}
