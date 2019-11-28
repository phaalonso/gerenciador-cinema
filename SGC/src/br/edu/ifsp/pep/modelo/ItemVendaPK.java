package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.Objects;

public class ItemVendaPK implements Serializable {
    
    private Integer item;
    private Integer venda;

    public ItemVendaPK() {
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getVenda() {
        return venda;
    }

    public void setVenda(Integer venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.item);
        hash = 97 * hash + Objects.hashCode(this.venda);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemVendaPK other = (ItemVendaPK) obj;
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        return true;
    }
}
