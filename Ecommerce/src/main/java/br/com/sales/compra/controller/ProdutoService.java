/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.compra.controller;

import br.com.sales.compra.DAO.GrupoProdutoVoDAO;
import br.com.sales.compra.DAO.ProdutoVoDAO;
import br.com.sales.compra.model.UploadArquivo;
import br.com.sales.dao.vo.GrupoProduto;
import br.com.sales.dao.vo.ItemCompra;
import br.com.sales.dao.vo.ProdutoVO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author MarcosAntonio
 */
@ManagedBean
@SessionScoped
public class ProdutoService {

    private ProdutoVO produtovo;
    private List<ProdutoVO> listaProdutos;
    private int grupoid;
    private GrupoProduto grupo;
    String grpoIid;
    
    private ItemCompra itemCompra;

    private UploadArquivo arquivo = new UploadArquivo();
    private UploadedFile file;

    private static ProdutoVoDAO produtodao;
    private static GrupoProdutoVoDAO grupodao;

    public ProdutoService() {
        produtovo = new ProdutoVO();
        grupo = new GrupoProduto();
        itemCompra = new ItemCompra();
    }

    public ItemCompra getItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }

    public ProdutoVO getProdutovo() {
        return produtovo;
    }

    public void setProdutovo(ProdutoVO produtovo) {
        this.produtovo = produtovo;
    }

    public List<ProdutoVO> getListaProdutos() {
        this.listaProdutos = br.com.sales.compra.DAO.ProdutoVoDAO.getInstance().getAll();
        return listaProdutos;
    }

    public void setListaProdutos(List<ProdutoVO> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public UploadArquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(UploadArquivo arquivo) {
        this.arquivo = arquivo;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
        this.produtovo.setFoto(file.getFileName().toString());
    }

    public int getGrupoid() {
        return grupoid;
    }

    public void setGrupoid(int grupoid) {
        this.grupoid = grupoid;
    }

    public GrupoProduto getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoProduto grupo) {
        this.grupo = grupo;
    }

    public String getGrpoIid() {
        return grpoIid;
    }

    public void setGrpoIid(String grpoIid) {
        this.grpoIid = grpoIid;
    }

    public void persist(ProdutoVO entity) {
        this.grupo = br.com.sales.compra.DAO.GrupoProdutoVoDAO.getInstance().getById(grupoid);           //setId(grupoid);
        this.produtovo.setGrupo(grupo);
        
        br.com.sales.compra.DAO.ProdutoVoDAO.getInstance().saveOrUpdate(produtovo);
        this.arquivo.gravar();
        this.produtovo = new ProdutoVO();
        this.arquivo = new UploadArquivo();
        this.listaProdutos = null;
    }

    public void update(ProdutoVO entity) {
        br.com.sales.compra.DAO.ProdutoVoDAO.getInstance().update(produtovo);
    }
    
    public void teste(){
        System.out.println("Teste");
    }

    public String preparaAlteracao(ProdutoVO entity) { 
      return "/produto/cadastro-produto.xhtml";
    }

    public ProdutoVO findById(String id) {
        return produtovo;
    }

    public void delete(String id) {
        br.com.sales.compra.DAO.ProdutoVoDAO.getInstance().delete(produtovo);

    }

    /*   public List<ProdutoVO> findAll() {
        
        return listaProdutos;
    } */
    public void deleteAll() {

    }

    public ProdutoVoDAO produtodao() {
        return produtodao;
    }

    public void uploadAction(FileUploadEvent event) {
        this.arquivo.fileUpload(event, ".jpg", "resources/images/");
        this.produtovo.setFoto(arquivo.getNome());
        this.produtovo.setPath(this.arquivo.getCaminho());
        FacesMessage message = new FacesMessage("Sucesso!!! ", event.getFile().getFileName() + " foi inserido.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void salvar() {
        //    produtodao.    save(produtovo);
        this.arquivo.gravar();
        this.produtovo = new ProdutoVO();
        this.arquivo = new UploadArquivo();
    }

}
