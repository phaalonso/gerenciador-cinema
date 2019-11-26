/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.controle;
import br.edu.ifsp.pep.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author pedro
 */
public class ControleUsuario extends ControleGenerico<Usuario>{

    public ControleUsuario() {
        super(Usuario.class);
    }

    public Usuario login(String login, String senha) throws NoResultException{
        EntityManager em = getEntityManager();
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.login", Usuario.class)
                .setParameter("login", login)
                .setParameter("senha", senha)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getSingleResult();
    }
    


}
