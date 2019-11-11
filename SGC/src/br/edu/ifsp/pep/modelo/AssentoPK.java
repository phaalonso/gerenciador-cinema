package br.edu.ifsp.pep.modelo;

import java.io.Serializable;

public class AssentoPK implements Serializable {
    
    private String codigo;
    private Integer sala; // Mesmo tipo da PK de sala

    public AssentoPK() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        return (int)this.codigo.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof AssentoPK))
            return false;
        AssentoPK other = (AssentoPK) object;
        return other.codigo.equals(this.codigo) && other.sala.equals(this.sala);
    }
}
