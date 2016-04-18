package br.com.sales.dao.vo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
 *
 * @author MarcosAntonio
 */
@Entity
@Table(name = "produtovo")
public class ProdutoVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private float preco;
    private String foto;
    private String path;
    //   cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.REFRESH})   
    private GrupoProduto grupo;
   
    public ProdutoVO() {
       //promocao = false;
        grupo = new GrupoProduto();
    }

    public ProdutoVO(String nome, String foto) {
        this.nome = nome;
        this.foto = foto;
    }

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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public GrupoProduto getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoProduto grupo) {
        this.grupo = grupo;
    }

    /* public boolean isPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    } */
    
    @Override
    public String toString() {
        return "ProdutoVO: " + this.nome + "," + this.foto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProdutoVO other = (ProdutoVO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }



}
