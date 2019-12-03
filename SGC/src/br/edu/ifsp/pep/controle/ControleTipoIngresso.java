/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.controle;
import br.edu.ifsp.pep.modelo.TipoIngresso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author pedro
 */
public class ControleTipoIngresso extends ControleGenerico<TipoIngresso>{

    public ControleTipoIngresso() {
        super(TipoIngresso.class);
    }
    
    public TipoIngresso findByNome(String descricao){
        EntityManager em = getEntityManager();
        TypedQuery<TipoIngresso> query = em.createNamedQuery("TipoIngresso.findByNome", 
                TipoIngresso.class)
                .setParameter("descricao", descricao)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);     
        return query.getSingleResult();
    }
}
