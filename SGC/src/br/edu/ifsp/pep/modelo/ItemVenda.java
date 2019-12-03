package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@IdClass(ItemVendaPK.class)
@Entity
@Table(name = "item_venda")
public class ItemVenda implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "item_codigo", nullable = false)
    private Item item;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "venda_codigo", nullable = false)
    private Venda venda;
    
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    
    @Column(name = "valor_unitario", nullable = false)
    private double valorUnitario;
    
    public ItemVenda() {
    }

    public ItemVenda(Venda venda, Item item, int quantidade, double valorUnitario) {
        this.venda = venda;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.item = item;
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

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
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
