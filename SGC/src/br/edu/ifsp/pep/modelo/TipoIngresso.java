package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_ingresso")
@NamedQueries({
    @NamedQuery(name = "TipoIngresso.findAll",
            query = "SELECT t FROM TipoIngresso t"),
    @NamedQuery(name = "TipoIngresso.findByCOdigo",
            query = "SELECT t FROM TipoIngresso t WHERE t.codigo = :codigo")
})
public class TipoIngresso implements Serializable{
    @Id
    @Column(name = "codigo")
    private Integer codigo;
    
    @Column(name = "valor", nullable = false)
    private double valor;
    
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    public TipoIngresso() {
    }

    public TipoIngresso(Integer codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return "TipoIngresso{" + "codigo=" + codigo + ", valor=" + valor + ", descricao=" + descricao + '}';
    }
    
}
