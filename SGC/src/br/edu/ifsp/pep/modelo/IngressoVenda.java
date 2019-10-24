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
import javax.persistence.ManyToOne;
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
    
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    
    @Column(name = "valor_unitario", nullable = false)
    private double valorUnitario;
    
    @OneToOne
    private Ingresso ingresso;

    @OneToOne
    private TipoIngresso tipo;
    
    @ManyToOne
    private Venda venda;
    
    public IngressoVenda() {
    }

    public IngressoVenda(Integer codigo, Ingresso ingresso, TipoIngresso tipo, Integer quantidade, Venda venda) {
        this.codigo = codigo;
        this.venda = venda;
        this.quantidade = quantidade;
        this.ingresso = ingresso;
        this.tipo = tipo;
        this.valorUnitario = tipo.getValor();
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }
    
    public double calcularSubTotal(){
        return this.quantidade * this.valorUnitario;
    }
}
