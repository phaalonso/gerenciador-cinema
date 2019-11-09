/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "assento")
@NamedQueries({
    @NamedQuery(name = "Assento.findAll",
            query = "SELECT a FROM Assento a"),
    @NamedQuery(name = "Assento.findByCodigo",
            query = "SELECT a FROM Assento a WHERE a.codigo = :codigo")
})
public class Assento implements Serializable{
    @Id
    private String codigo;
    
    @Column(name = "disponivel")
    private boolean disponivel;
    
    @ManyToMany
    private List<Sessao> sessaos;
 
    public Assento() {
    }

    public Assento(String codigo, boolean disponivel) {
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.sessaos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Sessao> getSessaos() {
        return sessaos;
    }

    public void setSessaos(List<Sessao> sessaos) {
        this.sessaos = sessaos;
    }
    
    @Override
    public String toString() {
        return "Assento{" + "codigo=" + codigo + ", disponivel=" + disponivel + '}';
    }
}
