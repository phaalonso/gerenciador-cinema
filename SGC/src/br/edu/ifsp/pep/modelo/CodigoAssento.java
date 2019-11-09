/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author pedro
 */
@Embeddable
public class CodigoAssento implements Serializable {
    @Column(name="sala_codigo", nullable = false)
    private Integer codigoSala;
    @Column(name="codigo", length = 3, nullable = false)
    private String codigo;

    public CodigoAssento() {
    }

    public CodigoAssento(Integer codigoSala, String codigo) {
        this.codigoSala = codigoSala;
        this.codigo = codigo;
    }

    public Integer getCodigoSala() {
        return codigoSala;
    }

    public void setCodigoSala(Integer codigoSala) {
        this.codigoSala = codigoSala;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigoSala);
        hash = 97 * hash + Objects.hashCode(this.codigo);
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
        final CodigoAssento other = (CodigoAssento) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.codigoSala, other.codigoSala)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CodigoAssento{" + "codigoSala=" + codigoSala + ", codigo=" + codigo + '}';
    }
    
}
