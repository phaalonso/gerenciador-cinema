package br.edu.ifsp.pep.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "combo")
@DiscriminatorValue(value = "combo")
@NamedQueries({
    @NamedQuery(name = "Combo.findByCodigo",
            query = "SELECT c FROM Combo c WHERE c.codigo = :codigo")
})
public class Combo extends Item{        
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            mappedBy = "combo")
    private List<ComboProduto> produtos;

    public Combo() {
    }

    public Combo(Integer codigo, String descricao, double preco) {
        super(codigo, descricao, preco);
        this.produtos = new ArrayList<>();
    }

    public List<ComboProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ComboProduto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Combo{" + "produtos=" + produtos + '}';
    }
}
