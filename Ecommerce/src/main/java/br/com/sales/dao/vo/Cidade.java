/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.dao.vo;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author Leandro Klein
 */
@Entity
public class Cidade {
    @Id
    private int id;
    private String nome;
    @ManyToOne
    private Estado estado;
    
    @Transient
    private ArrayList<Estado> listaDeEstados;
    
    public Cidade(){
        estado = new Estado();
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public ArrayList<Estado> getListaDeEstados(){
        listaDeEstados = new ArrayList<>();
        
        Estado alagoas = new Estado();
        alagoas.setNome("Alagoas");
        alagoas.setUf("AL");
        listaDeEstados.add(alagoas);
        
        Estado amapa = new Estado();
        amapa.setNome("Amapa");
        amapa.setUf("AP");
        listaDeEstados.add(amapa);

        Estado amazonas = new Estado();
        amazonas.setNome("Amazonas");
        amazonas.setUf("AM");
        listaDeEstados.add(amazonas);
        
        Estado bahia = new Estado();
        bahia.setNome("Bahia");
        bahia.setUf("BA");
        listaDeEstados.add(bahia);
        
        Estado ceara = new Estado();
        ceara.setNome("Ceará");
        ceara.setUf("CE");
        listaDeEstados.add(ceara);
        
        Estado destritofederal = new Estado();
        destritofederal.setNome("Distrito Federal");
        destritofederal.setUf("DF");
        listaDeEstados.add(destritofederal);
        
        Estado espiritosanto = new Estado();
        espiritosanto.setNome("Espírito Santo");
        espiritosanto.setUf("ES");
        listaDeEstados.add(espiritosanto);      
                                        
        Estado goias = new Estado();
        goias.setNome("Goiás");
        goias.setUf("GO");
        listaDeEstados.add(goias);
        
        Estado maranhao = new Estado();
        maranhao.setNome("Maranhão");
        maranhao.setUf("MA");
        listaDeEstados.add(maranhao);
                                        
        Estado matogrosso = new Estado();
        matogrosso.setNome("Mato Grosso");
        matogrosso.setUf("MT");
        listaDeEstados.add(matogrosso);                                
                                        
        Estado matogrossodosul = new Estado();
        matogrossodosul.setNome("Mato Grosso do Sul");
        matogrossodosul.setUf("MS");
        listaDeEstados.add(matogrossodosul);
        
        Estado minasgerais = new Estado();
        minasgerais.setNome("Minas Gerais");
        minasgerais.setUf("MG");
        listaDeEstados.add(minasgerais);
        
        Estado para = new Estado();
        para.setNome("Pará");
        para.setUf("PA");
        listaDeEstados.add(para);                                        
                                       
        Estado paraiba = new Estado();
        paraiba.setNome("Paraiba");
        paraiba.setUf("PB");
        listaDeEstados.add(paraiba);
        
        Estado parana = new Estado();
        parana.setNome("Paraná");
        parana.setUf("PR");
        listaDeEstados.add(parana);
        
        Estado pernambuco = new Estado();
        pernambuco.setNome("Pernambuco");
        pernambuco.setUf("PE");
        listaDeEstados.add(pernambuco);
        
        Estado piaui = new Estado();
        piaui.setNome("Piauí");
        piaui.setUf("PI");
        listaDeEstados.add(piaui);
                                        
        Estado riodejaneiro = new Estado();
        riodejaneiro.setNome("Rio de Janeiro");
        riodejaneiro.setUf("RJ");
        listaDeEstados.add(riodejaneiro);                                
                                        
        Estado rioGrandeDonorte = new Estado();
        rioGrandeDonorte.setNome("Rio Grande do Norte");
        rioGrandeDonorte.setUf("RN");
        listaDeEstados.add(rioGrandeDonorte);
        
        Estado riograndedosul = new Estado();
        riograndedosul.setNome("Rio Grande do Sul");
        riograndedosul.setUf("RN");
        listaDeEstados.add(riograndedosul);
                                        
        Estado rondonia = new Estado();
        rondonia.setNome("Rondônia");
        rondonia.setUf("RO");
        listaDeEstados.add(rondonia);
        
        Estado roraima = new Estado();
        roraima.setNome("Roraima");
        roraima.setUf("RR");
        listaDeEstados.add(roraima);
                                        
        Estado santaCatarina = new Estado();
        santaCatarina.setNome("Santa Catarina");
        santaCatarina.setUf("SC");
        listaDeEstados.add(santaCatarina);
        
        Estado saoPaulo = new Estado();
        saoPaulo.setNome("São Paulo");
        saoPaulo.setUf("SP");
        listaDeEstados.add(saoPaulo);
                                        
        Estado sergipe = new Estado();
        sergipe.setNome("Sergipe");
        sergipe.setUf("SE");
        listaDeEstados.add(sergipe);
        
        Estado tocantins = new Estado();
        tocantins.setNome("Tocantins");
        tocantins.setUf("TO");
        listaDeEstados.add(tocantins);
        
        return listaDeEstados;
    }
}
