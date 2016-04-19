/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.model;

import br.com.sales.dao.vo.Usuario;

/**
 *
 * @author MarcosAntonio
 */
public class testeUsuario {
    public static void main(String[] args) {
        Usuario u = new Usuario();
        u.setNome("juarez3");
        u.setEmail("Marcos@gmail.com");
        u.setSenha("123");
        
        br.com.sales.compra.DAO.UsuarioDAO.getInstance().save(u);
        
        System.out.println("O usuário é: " + u.getNome());
    }
}
