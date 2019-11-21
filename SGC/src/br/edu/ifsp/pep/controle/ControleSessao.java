/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.controle;
import br.edu.ifsp.pep.modelo.Sessao;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author pedro
 */
public class ControleSessao extends ControleGenerico<Sessao>{

    public ControleSessao() {
        super(Sessao.class);
    }

    public List<Sessao> localizarConflito(Date dataInicio, Date dataFim, 
            Time horaInicio, Time horaFim,Integer sala){
                dataInicio.setTime(horaInicio);
                dataFim.setTime(horaFim);
        EntityManager em = getEntityManager();
        TypedQuery<Sessao> query = em.createNamedQuery("Sessao.findConflito", Sessao.class)
                .setParameter("sala", sala)
                .setParameter("dataInicio", dataInicio)
                .setParameter("dataFim", dataFim)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);        
        return query.getResultList();
    }
    


}
