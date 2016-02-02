/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleoEcommerce.vo;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Leandro Klein
 */
@Entity
public class Vendas {
    @Id
    private int id;
    private double total;
    
    private ArrayList<Produto> listaDeProdutos;
    private Cliente cliente;
}
