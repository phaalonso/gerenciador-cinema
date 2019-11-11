package br.edu.ifsp.pep.modelo;

import java.io.Serializable;

public class IngressoPK implements Serializable {
    
    private Integer sessao; // Mesmo tipo da PK de sessao
    private AssentoPK assento; // Mesmo tipo da PK de sala

    public IngressoPK() {
    }

    public Integer getSessao() {
        return sessao;
    }

    public void setSessao(Integer sessao) {
        this.sessao = sessao;
    }

    public AssentoPK getAssento() {
        return assento;
    }

    public void setAssento(AssentoPK assento) {
        this.assento = assento;
    }

    @Override
    public int hashCode() {
        return (int)this.assento.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof IngressoPK))
            return false;
        IngressoPK other = (IngressoPK) object;
        return other.sessao.equals(this.sessao) && other.assento.equals(this.assento);
    }
}
