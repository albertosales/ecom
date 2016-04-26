package br.com.sales.compra.controller;

import br.com.sales.dao.vo.Produto;
import br.com.sales.dao.vo.ProdutoPromocao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "produtoPromo")
@SessionScoped
public class ProdutoController {
    
    private List<ProdutoPromocao> listaDeProduto;

    private Produto produto;

    public ProdutoController() {
        produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
