package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@IdClass(IngressoPK.class)
@Entity
@Table(name = "ingresso")
public class Ingresso implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "sessao_codigo", referencedColumnName = "codigo")
    private Sessao sessao;
    
    @Id
    @ManyToOne
    @JoinColumns(value = {
        @JoinColumn(name = "assento_codigo", referencedColumnName = "codigo"),
        @JoinColumn(name = "assento_sala_codigo", referencedColumnName = "sala_codigo")
    })
    private Assento assento;
    
    @ManyToOne
    @JoinColumn(name = "codigo_venda", referencedColumnName = "codigo", nullable = false)
    private Venda venda;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "codigo", name = "tipo_ingresso", nullable = false)
    private TipoIngresso tipo;
    
    @Column(name = "preco", nullable = false)
    private Double preco;
    
    public Ingresso() {
    }

    public Ingresso(Sessao sessao, Assento assento, Venda venda, TipoIngresso tipo, Double preco) {
        this.sessao = sessao;
        this.assento = assento;
        this.venda = venda;
        this.tipo = tipo;
        this.preco = preco;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngresso tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Ingresso{" + "sessao=" + sessao + ", assento=" + assento + ", venda=" + venda + ", tipo=" + tipo + ", preco=" + preco + '}';
    }
}
