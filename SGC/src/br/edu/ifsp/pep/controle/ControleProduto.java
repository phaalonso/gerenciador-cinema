/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.controle;
import br.edu.ifsp.pep.modelo.Produto;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author pedro
 */
public class ControleProduto extends ControleGenerico<Produto>{

    public ControleProduto() {
        super(Produto.class);
    }

    
    public Produto findByCodigo(Integer codigo) throws NoResultException{
        EntityManager em = getEntityManager();
        TypedQuery<Produto> query = em.createNamedQuery("Produto.findByCodigo", Produto.class)
                .setParameter("codigo", codigo)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);        
        return query.getSingleResult();
    }
    


}
