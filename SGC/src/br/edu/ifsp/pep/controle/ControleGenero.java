/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.controle;

import br.edu.ifsp.pep.modelo.Genero;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.QueryHint;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author pedro
 */
public class ControleGenero extends ControleGenerico<Genero>{
    public ControleGenero(){
        super(Genero.class);
    }
    
    public Genero findByDesc(String desc) throws NoResultException{
        EntityManager em = getEntityManager();
        TypedQuery<Genero> query = em.createNamedQuery("Genero.findByDesc", Genero.class)
                .setParameter("desc", desc)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getSingleResult();
    }
    
    public Genero findByCodigo(Integer codigo) throws NoResultException{
        EntityManager em = getEntityManager();
        TypedQuery<Genero> query = em.createNamedQuery("Genero.findByCodigo", Genero.class)
                .setParameter("codigo", codigo)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getSingleResult();
    }
}
