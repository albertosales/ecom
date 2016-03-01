/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleoEcommerce.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import nucleoEcommerce.enumeradores.CategoriaProdutos;

/**
 *
 * @author Leandro Klein
 */
@Entity
public class Produto {
    @Id
    private int id;
    private String nome;
    private double preco, desconto;
    private CategoriaProdutos categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public CategoriaProdutos getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProdutos categoria) {
        this.categoria = categoria;
    }
}
