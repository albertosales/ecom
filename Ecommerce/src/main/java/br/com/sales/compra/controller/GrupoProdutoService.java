/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.controller;

import br.com.sales.compra.DAO.GrupoProdutoVoDAO;
import br.com.sales.dao.vo.GrupoProduto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MarcosAntonio
 */
@ManagedBean
@SessionScoped
public class GrupoProdutoService {

    private GrupoProduto grupo;
    private List<GrupoProduto> listaGrupos;

    private static GrupoProdutoVoDAO grupodao;

    public GrupoProdutoService() {
        grupo = new GrupoProduto();
    }

    public GrupoProduto getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoProduto grupo) {
        this.grupo = grupo;
    }

    public void setListaGrupos(List<GrupoProduto> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    public void persist(GrupoProduto entity) {
        br.com.sales.compra.DAO.GrupoProdutoVoDAO.getInstance().save(grupo);
    }

    public void update(GrupoProduto entity) {
        br.com.sales.compra.DAO.GrupoProdutoVoDAO.getInstance().update(grupo);
        //    grupodao.openCurrentSessionwithTransaction();
        //    grupodao.update(entity);
        //    grupodao.closeCurrentSessionwithTransaction();
    }

    public GrupoProduto findById(String id) {

        return grupo;
    }

    public void delete(String id) {
        br.com.sales.compra.DAO.GrupoProdutoVoDAO.getInstance().delete(grupo);
    }

    public List<GrupoProduto> getListaGrupos() {
        this.listaGrupos = br.com.sales.compra.DAO.GrupoProdutoVoDAO.getInstance().getAll();
        return listaGrupos;
    }

    /*    public List<GrupoProduto> findAll() {
        //    grupodao.
        //  br.com.sales.compra.DAO.GrupoProdutoVoDAO.getInstance().getAll();
        List<GrupoProduto> grupos = grupodao.getAll();
        //    grupodao.closeCurrentSession();
        return grupos;
    }  */
    public void deleteAll() {
        
    }

    public GrupoProdutoVoDAO grupodao() {
        return grupodao;
    }
}
