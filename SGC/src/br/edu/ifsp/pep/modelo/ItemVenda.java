package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_venda")
public class ItemVenda implements Serializable{
    @Id
    @Column(name = "codigo")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    
    @Column(name = "valor_unitario", nullable = false)
    private double valorUnitario;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "item_codigo", nullable = false)
    private Item item;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "venda_codigo", nullable = false)
    private Venda venda;
    
    public ItemVenda() {
    }

    public ItemVenda(Integer codigo, Item item, int quantidade, double valorUnitario) {
        this.codigo = codigo;
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
