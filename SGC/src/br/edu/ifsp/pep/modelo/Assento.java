package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@IdClass(AssentoPK.class)
@Entity
@Table(name = "assento")
@NamedQueries({
    @NamedQuery(name = "Assento.findAll",
            query = "SELECT a FROM Assento a"),
    @NamedQuery(name = "Assento.findByCodigo",
            query = "SELECT a FROM Assento a WHERE a.codigo = :codigo")
})
public class Assento implements Serializable{
    @Id
    @Column(name = "codigo", length = 3)
    private String codigo;
    
    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "codigo", name = "sala_codigo")
    private Sala sala;
    
    @Column(name = "disponivel", nullable = false)
    private boolean disponivel;
 
    public Assento() {
    }

    public Assento(String codigo, Sala sala, boolean disponivel) {
        this.codigo = codigo;
        this.sala = sala;
        this.disponivel = disponivel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    @Override
    public String toString() {
        return "Assento{" + "codigo=" + codigo + ", disponivel=" + disponivel + '}';
    }
}
