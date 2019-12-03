package br.edu.ifsp.pep.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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

    public Combo(String descricao, double preco) {
        super(descricao, preco);
        this.produtos = new ArrayList<>();
    }

    public List<ComboProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ComboProduto> produtos) {
        this.produtos = produtos;
    }
    
    @Override
    public boolean verificaEstoque(int qtd){
        int qtdTotal;
        int estoque;
        for(ComboProduto cp : this.getProdutos()){
            qtdTotal = cp.getQuantidade() * qtd;
            estoque = cp.getProduto().getEstoque();
            if(estoque < qtdTotal || estoque <= 0)
                return false;
        }
        return true;
    }
    
}
