/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalizaCompra;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;


/**
 *
 * @author Frede
 */

@ManagedBean
@ViewScoped
public class geraBoleto {
    
    private String teste = "Le Test";

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
    
    
    /*
       public geraBoleto(){
           Datas datas = Datas.novasDatas()
                .comDocumento(1, 5, 2008)
                .comProcessamento(1, 5, 2008)
                .comVencimento(2, 5, 2008);  

            Endereco enderecoBeneficiario = Endereco.novoEndereco()
                    .comLogradouro("Av das Empresas, 555")  
                    .comBairro("Bairro Grande")  
                    .comCep("01234-555")  
                    .comCidade("São Paulo")  
                    .comUf("SP");  

            //Quem emite o boleto
            Beneficiario beneficiario = Beneficiario.novoBeneficiario()  
                    .comNomeBeneficiario("Fulano de Tal")  
                    .comAgencia("1824").comDigitoAgencia("4")  
                    .comCodigoBeneficiario("76000")  
                    .comDigitoCodigoBeneficiario("5")  
                    .comNumeroConvenio("1207113")  
                    .comCarteira("18")  
                    .comEndereco(enderecoBeneficiario)
                    .comNossoNumero("9000206");  

            Endereco enderecoPagador = Endereco.novoEndereco()
                    .comLogradouro("Av dos testes, 111 apto 333")  
                    .comBairro("Bairro Teste")  
                    .comCep("01234-111")  
                    .comCidade("São Paulo")  
                    .comUf("SP");  

            //Quem paga o boleto
            Pagador pagador = Pagador.novoPagador()  
                    .comNome("Fulano da Silva")  
                    .comDocumento("111.222.333-12")
                    .comEndereco(enderecoPagador);

            Banco banco = new BancoDoBrasil();  

            Boleto boleto = Boleto.novoBoleto()  
                    .comBanco(banco)  
                    .comDatas(datas)  
                    .comBeneficiario(beneficiario)  
                    .comPagador(pagador)  
                    .comValorBoleto("200.00")  
                    .comNumeroDoDocumento("1234")  
                    .comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")  
                    .comLocaisDePagamento("local 1", "local 2");  

            GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);  

            // Para gerar um boleto em PDF  
            gerador.geraPDF("BancoDoBrasil.pdf");  

       }*/
}
