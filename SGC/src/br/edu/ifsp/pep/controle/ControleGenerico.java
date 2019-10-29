package br.edu.ifsp.pep.controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Aluno
 */
public class ControleGenerico<T> {

    protected EntityManagerFactory emf;
    private Class<T> classe;

    public ControleGenerico(Class<T> classe) {
        this.classe = classe;
        emf = Persistence.createEntityManagerFactory("SGCPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void persist(T objeto) throws MySQLIntegrityConstraintViolationException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }

    public void delete(T objeto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(objeto));
        em.getTransaction().commit();
    }

    public void alter(T objeto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
    }

    public List<T> findAll() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(classe));
        return em.createQuery(cq).getResultList();
    }
}
