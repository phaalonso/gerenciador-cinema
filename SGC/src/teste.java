
import br.edu.ifsp.pep.modelo.Assento;
import br.edu.ifsp.pep.modelo.Filme;
import br.edu.ifsp.pep.modelo.Ingresso;
import br.edu.ifsp.pep.modelo.Sala;
import br.edu.ifsp.pep.modelo.Sessao;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class teste {
    
    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("SGCPU");
        EntityManager em = emf.createEntityManager();

//        em.getTransaction().begin();
//        Filme f = new Filme(1, "Teste", "Teste", new Date(), 200, "FODA", 16);
//        em.persist(f);
//        
//        Sala sala = new Sala(1, true, 1);
//        Assento assento = new Assento("a1", true);
//        Assento assento2 = new Assento("a2", true);
//        em.persist(assento);
//        em.persist(assento2);
//        ArrayList<Assento> lA = new ArrayList<>();
//        lA.add(assento);
//        lA.add(assento2);
//        sala.setAssentos(lA);
//        em.persist(sala);
//        
//        Sessao s = new Sessao(1, "SessaoTeste", new Date(), f, sala);
//        em.persist(s);
//        
//        Thread.sleep(3);
//        Sessao s2 = new Sessao(1, "SessaoTeste2", new Date(), f, sala);
//        
//        Ingresso ing = new Ingresso(1, new Date(), s, assento);
//        em.persist(ing);
//        
//        Ingresso ing2 = new Ingresso(2, new Date(), s2, assento2);
//        em.persist(ing2);
//        
//        em.getTransaction().commit();
        
    }
}
