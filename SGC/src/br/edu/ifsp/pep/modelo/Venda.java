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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "venda")
@NamedQueries({
    @NamedQuery(name = "Venda.findAll",
            query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByCodigo",
            query = "SELECT v FROM Venda v WHERE v.codigo = :codigo")
})
public class Venda implements Serializable{
    @Id
    @Column(name = "codigo")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(name="data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "venda_item_venda",
            joinColumns = @JoinColumn(name = "venda_codigo"),
            inverseJoinColumns = @JoinColumn(name = "item_venda_codigo")
    )
    private List<ItemVenda> itens;
        
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "venda_ingresso",
            joinColumns = @JoinColumn(name = "venda_codigo"),
            inverseJoinColumns = {
                @JoinColumn(name = "ingresso_sessao_codigo", referencedColumnName = "sessao_codigo"),
                @JoinColumn(name = "ingresso_assento_codigo", referencedColumnName = "assento_codigo"),
                @JoinColumn(name = "ingresso_sala_codigo", referencedColumnName = "assento_sala_codigo")
            }
    )
    private List<Ingresso> ingressos;
    
    @ManyToOne()
    private UsuarioComum vendedor;

    public Venda() {
    }

    public Venda(Integer codigo, Date data) {
        this.codigo = codigo;
        this.data = data;
        this.itens = new ArrayList<>();
        this.ingressos = new ArrayList<>();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
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
