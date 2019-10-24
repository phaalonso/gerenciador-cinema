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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll",
            query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByCOdigo",
            query = "SELECT p FROM Produto p WHERE p.codigo = :codigo")
})
public class Produto extends Item{    
    @Column(name = "preco", nullable = false)
    private double preco;
    
    @Column(name = "estoque", nullable = false)
    private Integer estoque;

    public Produto() {
    }

    public Produto(Integer codigo, String descricao, double preco, Integer estoque) {
        super(codigo, descricao);
        this.preco = preco;
        this.estoque = estoque;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
