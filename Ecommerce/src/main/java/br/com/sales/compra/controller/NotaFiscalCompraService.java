/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.controller;

import br.com.sales.compra.model.HibernateUtil;
import br.com.sales.dao.vo.Item;
import br.com.sales.dao.vo.ItemCompra;
import br.com.sales.dao.vo.NotaFiscalCompra;
import br.com.sales.dao.vo.ProdutoVO;
import java.util.List;
import javafx.scene.control.Alert;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import static org.hibernate.criterion.Projections.id;

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
    private int produtoid;
    static int notaFiscalNum;
    private List<ItemCompra> listaItensNota;
    private String descProd;
    static int ide;
    static String nomeProd;
    private ProdutoService prodServ;

    private int itemNFid;
    private String itemNFfornecedor;
    private int itemNFnumNF;

    public NotaFiscalCompraService() {
        produtovo = new ProdutoVO();
        notaFiscalCompra = new NotaFiscalCompra();
        itemCompra = new ItemCompra();
        prodServ = new ProdutoService();
    }

    public ProdutoService getProdServ() {
        return prodServ;
    }

    public void setProdServ(ProdutoService prodServ) {
        this.prodServ = prodServ;
    }
    
    

    public int getProdutoid() {
        return produtoid;
    }

    public void setProdutoid(int produtoid) {
        this.produtoid = produtoid;
    }

    public int getItemNFid() {
        return itemNFid;
    }

    public void setItemNFid(int itemNFid) {
        this.itemNFid = itemNFid;
    }

    public String getItemNFfornecedor() {
        return itemNFfornecedor;
    }

    public void setItemNFfornecedor(String itemNFfornecedor) {
        this.itemNFfornecedor = itemNFfornecedor;
    }

    public int getItemNFnumNF() {
        return itemNFnumNF;
    }

    public void setItemNFnumNF(int itemNFnumNF) {
        this.itemNFnumNF = itemNFnumNF;
    }

    public static int getIde() {
        return ide;
    }

    public static void setIde(int ide) {
        NotaFiscalCompraService.ide = ide;
    }

    public static String getNomeProd() {
        return nomeProd;
    }

    public static void setNomeProd(String nomeProd) {
        NotaFiscalCompraService.nomeProd = nomeProd;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public int getNotaFiscalid() {
        return notaFiscalid;
    }

    public void setNotaFiscalid(int notaFiscalid) {
        this.notaFiscalid = notaFiscalid;
    }

    public static int getNotaFiscalNum() {
        return notaFiscalNum;
    }

    public static void setNotaFiscalNum(int notaFiscalNum) {
        NotaFiscalCompraService.notaFiscalNum = notaFiscalNum;
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

    public List<ItemCompra> getListaItens() {
        this.listaItens = br.com.sales.compra.DAO.ItemCompraDAO.getInstance().getAll();
        return listaItens;
    }

    public void setListaItens(List listaItens) {
        this.listaItens = listaItens;
    }

    public List<ItemCompra> getListaItensNota() {
        this.listaItensNota = br.com.sales.compra.DAO.ItemCompraDAO.getInstance().getListaItensCompra(notaFiscalid);
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

    public String persistNota(NotaFiscalCompra Entity) {
        br.com.sales.compra.DAO.NotaFiscalCompraDAO.getInstance().save(notaFiscalCompra);
        this.notaFiscalid = br.com.sales.compra.DAO.NotaFiscalCompraDAO.getInstance().getMaxNotaId(Entity);
        return "/produto/comprar-produtos2.xhtml";
    }

    public String persistItem(ItemCompra Entity) {
        ItemCompra item = new ItemCompra();
        item.setProdutovo(produtovo);
        item.setQuant(1);
        item.setValorUnitario(produtovo.getPreco());
        item.setNotaFiscalCompra(notaFiscalCompra);
        
        listaItens.add(item);

        System.out.println(produtovo);
        
        br.com.sales.compra.DAO.ItemCompraDAO.getInstance().saveOrUpdate(Entity);
        return "/produto/comprar-produtos2.xhtml";
    }
    
    public void pegarId() {
        HibernateUtil.getSession().getCurrentSession();
        descProd = produtovo.getNome();
        br.com.sales.compra.DAO.ProdutoVoDAO.getInstance().getIdProdVO(descProd);
        
    }

    public String comprarProduto() {
        this.produtovo = br.com.sales.compra.DAO.ProdutoVoDAO.getInstance().getById(produtovo.getId());

        return "/produto/comprar-produtos2.xhtml";
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
