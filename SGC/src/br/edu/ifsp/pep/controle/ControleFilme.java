/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.controle;
import br.edu.ifsp.pep.modelo.Filme;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author pedro
 */
public class ControleFilme extends ControleGenerico<Filme>{

    public ControleFilme() {
        super(Filme.class);
    }

    public Filme findByCodigo(Integer codigo) throws NoResultException{
        EntityManager em = getEntityManager();
        TypedQuery<Filme> query = em.createNamedQuery("Filme.findByCodigo", Filme.class)
                .setParameter("codigo", codigo)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);  
        return query.getSingleResult();
    }
    


}
