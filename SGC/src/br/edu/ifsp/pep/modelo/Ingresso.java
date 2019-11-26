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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@IdClass(IngressoPK.class)
@Entity
@Table(name = "ingresso")
@NamedQueries({
    @NamedQuery(name = "Ingresso.findAll",
            query = "SELECT i FROM Ingresso i")
})
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
    
    @Column(name = "data_venda", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(referencedColumnName = "codigo", name = "tipo_ingresso", nullable = false)
    private TipoIngresso tipo;
    
    public Ingresso() {
    }

    public Ingresso(Sessao sessao, Assento assento, Date dataVenda, TipoIngresso tipo) {
        this.sessao = sessao;
        this.assento = assento;
        this.dataVenda = dataVenda;
        this.tipo = tipo;
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

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngresso tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "Ingresso{dataVenda=" + dataVenda + '}';
    }
}
