/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleoEcommerce.vo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Leandro Klein
 */
@Entity
public class Vendas {
    @Id
    private int id;
    private double total;
    @ManyToMany
    private List<Produto> listaDeProdutos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    
}
