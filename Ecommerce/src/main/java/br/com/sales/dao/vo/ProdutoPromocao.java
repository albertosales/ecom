package br.com.sales.dao.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdutoPromocao implements Serializable {
    private Date dataInicio;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codProduto;
    private String descricao;
    private Date dataExpiracao;
    private double precoProdutoPromocao;
    private int descontoProduto;
    
    

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public double getPrecoProdutoPromocao() {
        return precoProdutoPromocao;
    }

    public void setPrecoProdutoPromocao(double precoProdutoPromocao) {
        this.precoProdutoPromocao = precoProdutoPromocao;
    }

    public int getDescontoProduto() {
        return descontoProduto;
    }

    public void setDescontoProduto(int descontoProduto) {
        this.descontoProduto = descontoProduto;
    }

}