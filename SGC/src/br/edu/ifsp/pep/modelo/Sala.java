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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "sala")
@NamedQueries({
    @NamedQuery(name = "Sala.findAll",
            query = "SELECT s FROM Sala s"),
    @NamedQuery(name = "Sala.findByCodigo",
            query = "SELECT s FROM Sala s WHERE s.codigo = :codigo")
})
public class Sala implements Serializable{
    @Id
    private Integer codigo;
    
    @Column(name = "disponivel")
    private boolean disponivel;

    @Column(name = "qtdAssento")
    private Integer qtdAssendo;

    public Sala() {
    }

    public Sala(Integer codigo, boolean disponivel, Integer qtdAssendo) {
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.qtdAssendo = qtdAssendo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getQtdAssendo() {
        return qtdAssendo;
    }

    public void setQtdAssendo(Integer qtdAssendo) {
        this.qtdAssendo = qtdAssendo;
    }

    @Override
    public String toString() {
        return "Sala{" + "codigo=" + codigo + ", disponivel=" + disponivel + ", qtdAssendo=" + qtdAssendo + '}';
    }

}