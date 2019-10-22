/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "combo")
public class Combo implements Serializable{
    @Id
    private Integer codigo;
    
    @Column(name = "preco", nullable = false)
    private double preco;

    public Combo() {
    }

    public Combo(Integer codigo, double preco) {
        this.codigo = codigo;
        this.preco = preco;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Combo{" + "codigo=" + codigo + ", preco=" + preco + '}';
    }
    
    
    
    
}
