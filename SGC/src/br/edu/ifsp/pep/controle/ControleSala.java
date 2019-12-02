/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.controle;
import br.edu.ifsp.pep.modelo.Sala;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author pedro
 */
public class ControleSala extends ControleGenerico<Sala>{

    public ControleSala() {
        super(Sala.class);
    }
    
    public Sala findByCodigo(Integer codigo){
        EntityManager em = getEntityManager();
        TypedQuery<Sala> query = em.createNamedQuery("Sala.findByCodigo", Sala.class)
                .setParameter("codigo", codigo)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getSingleResult();
    }
    
    


}
