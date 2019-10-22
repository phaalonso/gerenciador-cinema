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
@Table(name = "venda")
public class Venda implements Serializable{
    @Id
    private Integer codigo;
    
    @Column(name = "valorTotal")
    private double valorTotal;

    public Venda() {
    }

    public Venda(Integer codigo, double valorTotal) {
        this.codigo = codigo;
        this.valorTotal = valorTotal;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", valorTotal=" + valorTotal + '}';
    }
    
}
