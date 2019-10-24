/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "combo")
@NamedQueries({
    @NamedQuery(name = "Combo.findAll",
            query = "SELECT c FROM Combo c"),
    @NamedQuery(name = "Combo.findByCOdigo",
            query = "SELECT c FROM Combo c WHERE c.codigo = :codigo")
})
public class Combo extends Item{    
    @Column(name = "preco", nullable = false)
    private double preco;
    
    @OneToMany()
    private List<Produto> produtos;

    public Combo() {
    }

    public Combo(Integer codigo, String descricao, double preco) {
        super(codigo, descricao);
        this.preco = preco;
        this.produtos = new ArrayList<>();
    }

    public double getPreco() {
        return preco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
