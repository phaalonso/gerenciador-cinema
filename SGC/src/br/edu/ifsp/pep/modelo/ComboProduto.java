/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author pedro
 */

@IdClass(ComboProdutoPK.class)
@Entity
@Table(name = "combo_produto")
@NamedQueries({
    @NamedQuery(name = "ComboProduto.findByComboCodigo", 
            query = "SELECT c FROM ComboProduto c WHERE c.combo = :combo")
})
public class ComboProduto implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "combo_codigo", referencedColumnName = "codigo")
    private Combo combo;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "produto_codigo", referencedColumnName = "codigo")
    private Produto produto;
    
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public ComboProduto() {
    }

    public ComboProduto(Combo combo, Produto Produto, Integer quantidade) {
        this.combo = combo;
        this.produto = Produto;
        this.quantidade = quantidade;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }        

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.combo);
        hash = 59 * hash + Objects.hashCode(this.produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComboProduto other = (ComboProduto) obj;
        if (!Objects.equals(this.combo, other.combo)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ComboProduto{" + "combo=" + combo.getCodigo() + ", produto=" + produto.getCodigo() + ", quantidade=" + quantidade + '}';
    }
}
