/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.controller;

import br.com.sales.dao.vo.ItemCompra;
import br.com.sales.dao.vo.NotaFiscalCompra;
import br.com.sales.dao.vo.ProdutoVO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MarcosAntonio
 */
@ManagedBean
@SessionScoped
public class NotaFiscalCompraService {
    
    private NotaFiscalCompra notaFiscalCompra;
    private ItemCompra itemCompra;
    private ProdutoVO produtovo;
    private List<ItemCompra> listaItens;
    private List<NotaFiscalCompra> listaNotaFiscalCompra;
    private int notaFiscalid;
    private List<ItemCompra> listaItensNota;
    
    public NotaFiscalCompraService() {
        produtovo = new ProdutoVO();
        notaFiscalCompra = new NotaFiscalCompra();
        itemCompra = new ItemCompra();
    }
    
    public int getNotaFiscalid() {
        return notaFiscalid;
    }
    
    public void setNotaFiscalid(int notaFiscalid) {
        this.notaFiscalid = notaFiscalid;
    }
    
    public ItemCompra getItemCompra() {
        return itemCompra;
    }
    
    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }
    
    public NotaFiscalCompra getNotaFiscalCompra() {
        return notaFiscalCompra;
    }
    
    public void setNotaFiscalCompra(NotaFiscalCompra notaFiscalCompra) {
        this.notaFiscalCompra = notaFiscalCompra;
    }
    
    public ProdutoVO getProdutovo() {
        return produtovo;
    }
    
    public void setProdutovo(ProdutoVO produtovo) {
        this.produtovo = produtovo;
    }
    
    public List getListaItens() {
        this.listaItens = br.com.sales.compra.DAO.ItemCompraDAO.getInstance().getAll();
        return listaItens;
    }
    
    public void setListaItens(List listaItens) {
        this.listaItens = listaItens;
    }
    
    public List<ItemCompra> getListaItensNota() {
        return listaItensNota;
    }
    
    public void setListaItensNota(List<ItemCompra> listaItensNota) {
        this.listaItensNota = listaItensNota;
    }
    
    public List<NotaFiscalCompra> getListaNotaFiscalCompra() {
        this.listaNotaFiscalCompra = br.com.sales.compra.DAO.NotaFiscalCompraDAO.getInstance().getAll();
        return listaNotaFiscalCompra;
    }
    
    public void setListaNotaFiscalCompra(List<NotaFiscalCompra> listaNotaFiscalCompra) {
        this.listaNotaFiscalCompra = listaNotaFiscalCompra;
    }
    
    public void persistNota(NotaFiscalCompra Entity) {
        br.com.sales.compra.DAO.NotaFiscalCompraDAO.getInstance().save(notaFiscalCompra);
      //  return "/produto/comprar-produtos2.xhtml";
    }
    
    public void persistItem(ItemCompra Entity) {
        this.notaFiscalCompra = br.com.sales.compra.DAO.NotaFiscalCompraDAO.getInstance().getById(notaFiscalid);
        this.itemCompra.setNotaFiscalCompra(notaFiscalCompra);
        br.com.sales.compra.DAO.ItemCompraDAO.getInstance().save(itemCompra);
        this.itemCompra = new ItemCompra();
        this.listaItens = null;
    }
    
    public void update(NotaFiscalCompra Entity) {
        br.com.sales.compra.DAO.NotaFiscalCompraDAO.getInstance().update(notaFiscalCompra);
    }
    
    public void delete(NotaFiscalCompra Entity) {
        br.com.sales.compra.DAO.NotaFiscalCompraDAO.getInstance().delete(notaFiscalCompra);
    }
    
    public NotaFiscalCompra findById(String id) {
        return notaFiscalCompra;
    }
}
