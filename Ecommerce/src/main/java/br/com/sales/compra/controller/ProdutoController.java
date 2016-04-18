package br.com.sales.compra.controller;

import br.com.sales.dao.vo.ProdutoVO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "produto")
@SessionScoped
public class ProdutoController {

    private ArrayList<ProdutoVO> listaDeProduto;

    public ArrayList<ProdutoVO> getListaDeProduto() {
        
        return listaDeProduto;
    }
    
}
