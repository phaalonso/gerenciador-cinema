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
@Table(name = "item_venda")
public class ItemVenda implements Serializable{
    @Id
    private Integer codigo;
    
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    
    @Column(name = "valor_unitario", nullable = false)
    private double valorUnitario;
    
    @OneToOne
    private Item item;
    
    @ManyToOne
    private Venda venda;

    public ItemVenda() {
    }

    public ItemVenda(Integer codigo, Item item, int quantidade, double valorUnitario, Venda venda) {
        this.codigo = codigo;
        this.venda = venda;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.item = item;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    public double calcularSubTotal(){
        return this.quantidade * this.valorUnitario;
    }    
    
}
