/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pedro
 */
@Entity
@Table(name="sessao")
@NamedQueries({
    @NamedQuery(name = "Sessao.findAll",
            query = "SELECT s FROM Sessao s"),
    @NamedQuery(name = "Sessao.findByCodigo",
            query = "SELECT s FROM Sessao s WHERE s.codigo = :codigo")
})
public class Sessao implements Serializable {
    @Id
    private Integer codigo;
    
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;
    
    @Column(name = "datainicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    
    @OneToOne
    private Filme filme;
    
    @OneToMany(mappedBy = "sessao")
    private List<Ingresso> ingressos;
    
    @ManyToOne
    private Sala sala;
    
    public Sessao() {
    }

    public Sessao(Integer codigo, String descricao, Date dataInicio, Filme filme, Sala sala) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.filme = filme;
        this.ingressos = new ArrayList<>();
        this.sala = sala;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    @Override
    public String toString() {
        return "Sessao{" + "codigo=" + codigo + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", filme: " + this.filme.getTitulo() + '}';
    }
}
