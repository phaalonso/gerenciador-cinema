/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "venda")
@NamedQueries({
    @NamedQuery(name = "Venda.findAll",
            query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByCOdigo",
            query = "SELECT v FROM Venda v WHERE v.codigo = :codigo")
})
public class Venda implements Serializable{
    @Id
    private Integer codigo;
    
    @Column(name = "valorTotal")
    private double valorTotal;
    
    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> itens;
    
    @OneToMany(mappedBy = "venda")
    private List<IngressoVenda> ingressos;

    public Venda() {
    }

    public Venda(Integer codigo, double valorTotal) {
        this.codigo = codigo;
        this.valorTotal = valorTotal;
        this.itens = new ArrayList<>();
        this.ingressos = new ArrayList<>();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public List<IngressoVenda> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<IngressoVenda> ingressos) {
        this.ingressos = ingressos;
    }
    
    public double calcularTotal(){
        double total = 0;

        if(!this.itens.isEmpty()){
            try{
                for(ItemVenda itV : this.itens){
                    total += itV.calcularSubTotal();
                }
            }catch(NullPointerException ex){
                System.err.println("Null na lista de Items da venda: " + this.getCodigo());
            }   
        }
        if(!this.ingressos.isEmpty()){
            for(IngressoVenda igV : this.ingressos){
                try{
                    total += igV.calcularSubTotal();
            
                }catch(NullPointerException ex){
                    System.err.println("Null na lista de Ingresso da venda: " + this.getCodigo());
                }
            }
        }
        
        return total;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", valorTotal=" + valorTotal + '}';
    }
    
}
