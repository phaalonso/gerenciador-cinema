/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;

/**
 *
 * @author pedro
 */
public class ComboProdutoPK implements Serializable{
    @Column(name = "combo_codigo")
    private Integer combo;
    @Column(name = "produto_codigo")
    private Integer produto;

    public ComboProdutoPK() {
    }

    public ComboProdutoPK(Integer codigoCombo, Integer codigoProduto) {
        this.combo = codigoCombo;
        this.produto = codigoProduto;
    }

    public Integer getCodigoCombo() {
        return combo;
    }

    public void setCodigoCombo(Integer codigoCombo) {
        this.combo = codigoCombo;
    }

    public Integer getCodigoProduto() {
        return produto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.produto = codigoProduto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.combo);
        hash = 97 * hash + Objects.hashCode(this.produto);
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
        final ComboProdutoPK other = (ComboProdutoPK) obj;
        if (!Objects.equals(this.combo, other.combo)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }
}
