/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.controle;
import br.edu.ifsp.pep.modelo.UsuarioComum;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author pedro
 */
public class ControleUsuario extends ControleGenerico<UsuarioComum>{

    public ControleUsuario() {
        super(UsuarioComum.class);
    }

    public UsuarioComum login(String login, String senha){
        EntityManager em = getEntityManager();
        TypedQuery<UsuarioComum> query = em.createNamedQuery("UsuarioComum.login", UsuarioComum.class)
                .setParameter("login", login)
                .setParameter("senha", senha)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getSingleResult();
    }
    


}
