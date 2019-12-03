package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_ingresso")
@NamedQueries({
    @NamedQuery(name = "TipoIngresso.findByNome",
            query = "SELECT t FROM TipoIngresso t WHERE t.descricao = :descricao")
})
public class TipoIngresso implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Column(name = "valor", nullable = false)
    private double valor;
    
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    public TipoIngresso() {
    }

    public TipoIngresso(String descricao, double valor) {
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
        return descricao;
    }
    
}
