/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleoEcommerce.interfaces;

import nucleoEcommerce.vo.ItemProduto;

/**
 *
 * @author Leandro Klein
 */
public interface ICarrinho {
    void adicionaAoCarrinho(ItemProduto itemProduto);
}
