/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.controle;
import br.edu.ifsp.pep.modelo.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author pedro
 */
public class ControleItem extends ControleGenerico<Item>{

    public ControleItem() {
        super(Item.class);
    }

    public Item findByCodigo(Integer codigo) throws NoResultException{
        EntityManager em = getEntityManager();
        TypedQuery<Item> query = em.createNamedQuery("Item.findByCodigo", Item.class)
                .setParameter("codigo", codigo)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);        
        return query.getSingleResult();
    }
    
    public List<Item> findByDesc(String desc){
        EntityManager em = getEntityManager();
        TypedQuery<Item> query = em.createNamedQuery("Item.findByDesc", Item.class)
                .setParameter("desc", "%" + desc + "%")
                .setHint(QueryHints.REFRESH, HintValues.TRUE);        
        return query.getResultList();
    }
    


}
