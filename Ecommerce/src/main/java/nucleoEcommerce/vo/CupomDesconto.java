/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleoEcommerce.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Leandro Klein
 */
@Entity
public class CupomDesconto {
    @Id
    private int id;
    private double valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {        
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}