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
@Table(name = "tipoingresso")
public class TipoIngresso implements Serializable{
    @Id
    private Integer codigo;
    
    @Column(name = "valor", nullable = false)
    private double valor;
    
    @Column(name = "descricao", length = 100)
    private String descricao;

    public TipoIngresso() {
    }

    public TipoIngresso(Integer codigo, double valor, String descricao) {
        this.codigo = codigo;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoIngresso{" + "codigo=" + codigo + ", valor=" + valor + ", descricao=" + descricao + '}';
    }
    
}
