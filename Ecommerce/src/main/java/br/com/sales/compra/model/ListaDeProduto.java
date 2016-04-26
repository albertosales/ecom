package br.com.sales.compra.model;

import br.com.sales.compra.DAO.ProdutoPromocaoDAO;
import br.com.sales.dao.vo.ProdutoPromocao;
import br.com.sales.dao.vo.ProdutoVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HENRIQUE
 */
public class ListaDeProduto implements br.com.sales.interfaces.IProduto{
    
    private final List<ProdutoPromocao> listaDeProduto;
    
    public ListaDeProduto(){
        
        listaDeProduto = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            ProdutoPromocao produto = new ProdutoPromocao();
            produto.getCodProduto();
            produto.getDataInicio();
            produto.getDataExpiracao();
            produto.getDescontoProduto();
            produto.getDescricao();
            produto.setPrecoProdutoPromocao(i);
            listaDeProduto.add(produto);
        }
    }

    @Override
    public void adicionaDesconto(ProdutoVO produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
