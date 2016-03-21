package nucleoEcommerce.vo;

import java.util.Date;

public class ProdutoPromocao {
    private Date dataInicio;
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