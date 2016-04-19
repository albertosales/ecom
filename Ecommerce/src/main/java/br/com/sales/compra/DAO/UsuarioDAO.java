/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.DAO;

import br.com.sales.dao.vo.Usuario;

/**
 *
 * @author MarcosAntonio
 */
public class UsuarioDAO extends DAO<Usuario>{
    private static UsuarioDAO dao;
    
    public UsuarioDAO(Class<Usuario> classe) {
        super(classe);
    }
    
     public static UsuarioDAO getInstance() {
        if(dao == null) {
            dao = new UsuarioDAO(Usuario.class);
        }
        return dao;
    }
}
