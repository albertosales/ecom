/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.model;

import br.com.sales.compra.controller.GrupoProdutoService;
import br.com.sales.dao.vo.GrupoProduto;
import java.util.List;

/**
 *
 * @author MarcosAntonio
 */
public class testeGrupo {
    public static void main(String[] args) {
        GrupoProduto g = new GrupoProduto();
        GrupoProdutoService gs = new GrupoProdutoService();
        List l = gs.getListaGrupos();
        l = br.com.sales.compra.DAO.GrupoProdutoVoDAO.getInstance().getAll();
        System.out.println("A lista é: " + l);
    }
}
