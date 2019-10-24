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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "ingresso_venda")
public class IngressoVenda implements Serializable{
    @Id
    private Integer codigo;
        
    @Column(name = "valor_unitario", nullable = false)
    private double valorUnitario;
    
    @OneToMany(mappedBy = "ingressoVenda")
    private List<Ingresso> ingresso;

    @OneToOne
    private TipoIngresso tipo;
    
    @ManyToOne
    private Venda venda;
    
    public IngressoVenda() {
    }

    public IngressoVenda(Integer codigo, TipoIngresso tipo, Venda venda) {
        this.codigo = codigo;
        this.venda = venda;
        this.tipo = tipo;
        this.valorUnitario = tipo.getValor();
        this.ingresso = new ArrayList<>();
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public List<Ingresso> getIngresso() {
        return ingresso;
    }

    public void setIngresso(List<Ingresso> ingresso) {
        this.ingresso = ingresso;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngresso tipo) {
        this.tipo = tipo;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    public double calcularSubTotal(){
        return this.ingresso.size() * this.valorUnitario;
    }
}
