/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.interfaces;

import br.com.sales.dao.vo.ProdutoVO;

/**
 *
 * @author HENRIQUE
 */
public interface IProduto{
    void adicionaDesconto (ProdutoVO produto);
}
