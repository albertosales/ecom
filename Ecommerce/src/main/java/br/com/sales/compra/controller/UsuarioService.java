/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.controller;

import br.com.sales.dao.vo.Usuario;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MarcosAntonio
 */

@ManagedBean
@SessionScoped
public class UsuarioService {
    
    private Usuario usuario;
    private List<Usuario> listaUsuarios;

    public UsuarioService() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

   public void persist(Usuario Entity) {
       br.com.sales.compra.DAO.UsuarioDAO.getInstance().save(usuario);
   }
   
   public void update(Usuario entity) {
        br.com.sales.compra.DAO.UsuarioDAO.getInstance().update(usuario);
    }

    public String preparaAlteracao(Usuario entity) { 
      return "/USERS/cadastro-usuario.xhtml";
    }

    public Usuario findById(String id) {
        return usuario;
    }

    public void delete(String id) {
        br.com.sales.compra.DAO.UsuarioDAO.getInstance().delete(usuario);

    }
}
