/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "ingresso", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sessao_codigo" , "assento_codigo"})
})
@NamedQueries({
    @NamedQuery(name = "Ingresso.findAll",
            query = "SELECT i FROM Ingresso i"),
    @NamedQuery(name = "Ingresso.findByCOdigo",
            query = "SELECT i FROM Ingresso i WHERE i.codigo = :codigo")
})
public class Ingresso implements Serializable{
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Column(name = "dataVenda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;

    //??
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "sessao_codigo", referencedColumnName = "codigo")
    private Sessao sessao;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "assento_codigo", referencedColumnName = "codigo")
    private Assento assento;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private TipoIngresso tipo;
    
    public Ingresso() {
    }

    public Ingresso(Integer codigo, Date dataVenda, Sessao sessao, Assento assento) {
        this.codigo = codigo;
        this.dataVenda = dataVenda;
        this.sessao = sessao;
        this.assento = assento;
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

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }
    
    @Override
    public String toString() {
        return "Ingresso{" + "codigo=" + codigo + ", dataVenda=" + dataVenda + '}';
    }
    
}
