package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sessao")
@NamedQueries({
    @NamedQuery(name = "Sessao.findByCodigo",
            query = "SELECT s FROM Sessao s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Sessao.findConflito",
            query = "SELECT s FROM Sessao s " 
                + "WHERE (s.arquivada = false) AND (s.sala = :sala)"
                    + "AND (CAST(s.dataInicio AS DATE) BETWEEN "
                        + "CAST(:dataInicio AS DATE) AND CAST(:dataFim AS DATE))")
})
public class Sessao implements Serializable {
    @Id
    @Column(name = "codigo")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;
    
    @Column(name = "data_inicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    
    @Column(name = "arquivada", nullable = false)
    private boolean arquivada;
    
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "filme_codigo", nullable = false)
    private Filme filme;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "sala_codigo", nullable = false)
    private Sala sala;
    
    @OneToMany(mappedBy = "sessao")
    private List<Ingresso> ingressos;
    
    public Sessao() {
    }

    public Sessao(Integer codigo, String descricao, Date dataInicio, Filme filme, Sala sala) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.filme = filme;
        this.sala = sala;
        this.arquivada = false;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public boolean isArquivada() {
        return arquivada;
    }

    public void setArquivada(boolean arquivada) {
        this.arquivada = arquivada;
    }
    
    public List<Assento> verificarAssentosDisponiveis(){
        List<Assento> lista = this.sala.getAssentos();
        List<Assento> assentosDisponiveis = new ArrayList<>();
        
        Assento a2;
        boolean disponivel;
        int index;
        
        for(Assento a : lista){
            disponivel = a.isDisponivel();
            if(disponivel){
                for(Ingresso i : ingressos){
                    a2 = i.getAssento();
                    index = 0;
                    while(index < lista.size() && 
                            !a2.getCodigo().equals(a.getCodigo()))
                        index++;
                    if(index == lista.size())
                        assentosDisponiveis.add(a);
                }
            }
        }
        
        return assentosDisponiveis;
    }
    
    @Override
    public String toString() {
        return "Sessao{" + "codigo=" + codigo + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", filme: " + this.filme.getTitulo() + '}';
    }
}
