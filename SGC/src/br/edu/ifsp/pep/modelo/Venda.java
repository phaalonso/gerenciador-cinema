/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(name="data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @OneToMany
    private List<ItemVenda> itens;

    public Venda() {
    }

    public Venda(Integer codigo, Date data) {
        this.codigo = codigo;
        this.data = data;
        this.itens = new ArrayList<>();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
    
    //TODO CalcularTotal
    public double calcularTotal(){
        double total = 0;
//
//        if(!this.itens.isEmpty()){
//            try{
//                for(ItemVenda itV : this.itens){
//                    total += itV.calcularSubTotal();
//                }
//            }catch(NullPointerException ex){
//                System.err.println("Null na lista de Items da venda: " + this.getCodigo());
//            }   
//        }
//        if(!this.ingressos.isEmpty()){
//            for(IngressoVenda igV : this.ingressos){
//                try{
//                    total += igV.calcularSubTotal();
//            
//                }catch(NullPointerException ex){
//                    System.err.println("Null na lista de Ingresso da venda: " + this.getCodigo());
//                }
//            }
//        }
//        
        return total;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", valorTotal=" + this.calcularTotal() + '}';
    }
    
}
