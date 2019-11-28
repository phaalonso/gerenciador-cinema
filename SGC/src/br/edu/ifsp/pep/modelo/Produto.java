package br.edu.ifsp.pep.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@DiscriminatorValue(value = "produto")
@NamedQueries({
    @NamedQuery(name = "Produto.findByCodigo",
            query = "SELECT p FROM Produto p WHERE p.codigo = :codigo")
})
public class Produto extends Item{        
    @Column(name = "estoque", nullable = false)
    private Integer estoque;

    public Produto() {
    }

    public Produto(Integer codigo, String descricao, double preco, Integer estoque) {
        super(codigo, descricao, preco);
        this.estoque = estoque;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Produto{" + "estoque=" + estoque + '}';
    }
    
}
