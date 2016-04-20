package br.com.sales.compra.controller;

import br.com.sales.compra.DAO.ProdutoPromocaoDAO;
import br.com.sales.dao.vo.ProdutoPromocao;
import br.com.sales.dao.vo.ProdutoVO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "produtoPromo")
@SessionScoped
public class ProdutoController {

    private List<ProdutoPromocao> listaDeProduto;

    public List<ProdutoPromocao> getListaDeProduto() {
        listaDeProduto = ProdutoPromocaoDAO.getInstance().getAll();
        return listaDeProduto;
    }
    
}
