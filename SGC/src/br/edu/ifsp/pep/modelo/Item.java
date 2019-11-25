package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "item")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
@NamedQueries({
    @NamedQuery(name = "Item.findByCodigo", query = "SELECT I FROM Item I WHERE I.codigo = :codigo"),
    @NamedQuery(name = "Item.findByDesc", query = "SELECT I FROM Item I WHERE I.descricao LIKE :desc")
})
public abstract class Item  implements Serializable{
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;
    
    @Column(name = "preco", nullable = false)
    private double preco;
    
    public Item() {
    }

    public Item(Integer codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Item{" + "codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + '}';
    }    
}
