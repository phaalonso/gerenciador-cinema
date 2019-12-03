/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.controle;
import br.edu.ifsp.pep.modelo.Sala;
import br.edu.ifsp.pep.modelo.Sessao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ControleSessao extends ControleGenerico<Sessao>{

    public ControleSessao() {
        super(Sessao.class);
    }
    
    public List<Sessao> findByTitulo(String titulo) throws NoResultException{
        EntityManager em = getEntityManager();
        TypedQuery<Sessao> query = em.createNamedQuery("Sessao.findByFilmeTitulo", Sessao.class)
                .setParameter("titulo", "%" + titulo + "%")
                .setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }
    
    public Sessao findByCodigo(Integer codigo) throws NoResultException{
        EntityManager em = getEntityManager();
        TypedQuery<Sessao> query = em.createNamedQuery("Sessao.findByCodigo", Sessao.class)
                .setParameter("codigo", codigo)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getSingleResult();
    }
    
    public List<Sessao> findNotArquivada() throws NoResultException{
        EntityManager em = getEntityManager();
        TypedQuery<Sessao> query = em.createNamedQuery("Sessao.findNotArquivada", Sessao.class)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }
    
    private boolean verificarHorarioEntre(Date data, Date inicio, Date fim){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String horaCompara, horarioInicio, horarioFim;
        horaCompara = sdf.format(data);
        horarioInicio = sdf.format(inicio);
        horarioFim = sdf.format(fim);
        
        if(horarioInicio.compareTo(horarioFim) > 0){ // se horario inicio for maior
            if(
                    horaCompara.compareTo(horarioInicio) >= 0
                    || horaCompara.compareTo(horarioFim) <= 0
                )
                return true;
        }else{
            if(
                    horaCompara.compareTo(horarioInicio) >= 0
                    && horaCompara.compareTo(horarioFim) <= 0
                )
                return true;
        }
        return false;
    }

    public List<Sessao> localizarConflito(Sala sala, Date dataInicio, Date dataFim){ 
        EntityManager em = getEntityManager();
        
        System.out.println("dataInicio = " + dataInicio);
        System.out.println("dataFim = " + dataFim);
        
        TypedQuery<Sessao> query = em.createNamedQuery("Sessao.findConflito", Sessao.class)
                .setParameter("sala", sala)
                .setParameter("dataInicio", dataInicio)
                .setParameter("dataFim", dataFim)
                .setHint(QueryHints.REFRESH, HintValues.TRUE);
        List<Sessao> queryList = query.getResultList();
        
        List<Sessao> listaSessao = new ArrayList<>();
        long milisegundos;
        if(!queryList.isEmpty()){
            System.out.println(queryList.size());
            for(Sessao s : queryList){
                milisegundos = s.getFilme().getDuracao() * 60 * 1000;
                if(verificarHorarioEntre(s.getDataInicio(), dataInicio, dataFim)
                        || verificarHorarioEntre(new Date(s.getDataInicio().getTime() + milisegundos), dataInicio, dataFim))
                    listaSessao.add(s);
            }
        }
        
        return listaSessao;
    }    


}
