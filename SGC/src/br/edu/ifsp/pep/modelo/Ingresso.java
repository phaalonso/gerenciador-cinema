/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "ingresso")
public class Ingresso implements Serializable{
    @Id
    private Integer codigo;
    
    @Column(name = "dataVenda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;

    public Ingresso() {
    }

    public Ingresso(Integer codigo, Date dataVenda) {
        this.codigo = codigo;
        this.dataVenda = dataVenda;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String toString() {
        return "Ingresso{" + "codigo=" + codigo + ", dataVenda=" + dataVenda + '}';
    }
    
}
