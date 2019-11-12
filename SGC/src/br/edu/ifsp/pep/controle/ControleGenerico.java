package br.edu.ifsp.pep.controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author cesar
 */
public class ControleGenerico<T> {

    private EntityManagerFactory emf;
    private Class<T> classe;

    public ControleGenerico(Class<T> classe) {
        this.classe = classe;
        emf = Persistence.createEntityManagerFactory("projBancoPU");
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void persist(T entity) {
        EntityManager em;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void remove(T entity) {
        EntityManager em;
        em = getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
        em.getTransaction().commit();
    }

    public void merge(T entity) {
        EntityManager em;
        em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

//    public List<T> findAll() {
//        EntityManager em = getEntityManager();
//        Query q = em.createNamedQuery("Agencia.Todas", classe);
//        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
//        return q.getResultList();
//
//    }

    public List<T> findAll() {
        EntityManager em = getEntityManager();
        
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(classe));
        
        return em.createQuery(cq).getResultList();
    }

}
