
import br.edu.ifsp.pep.controle.ControleSessao;
import br.edu.ifsp.pep.modelo.Assento;
import br.edu.ifsp.pep.modelo.Filme;
import br.edu.ifsp.pep.modelo.Ingresso;
import br.edu.ifsp.pep.modelo.Produto;
import br.edu.ifsp.pep.modelo.Sala;
import br.edu.ifsp.pep.modelo.Sessao;
import br.edu.ifsp.pep.modelo.TipoIngresso;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class teste {

    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("SGCPU");
        EntityManager em = emf.createEntityManager();

//        em.getTransaction().begin();
//        Filme f = new Filme(1, "Teste", "Teste", new Date(), 200, "FODA", 16);
//        em.persist(f);
//
//        Sala sala = new Sala(1, true, 1);
//        Sala sala2 = new Sala(2, true, 1);
//        //Assento assento = new Assento(new CodigoAssento(sala, "a01"), true);
//        //Assento assento2 = new Assento(new CodigoAssento(sala, "a02"), true);
//        Assento assento = new Assento("a01", sala, true);
//        Assento assento2 = new Assento("a02", sala, true);
//        Assento assento3 = new Assento("a01", sala2, true);
//        Assento assento4 = new Assento("a02", sala2, true);
//
//        em.persist(assento);
//        em.persist(assento2);
//        em.persist(assento3);
//        em.persist(assento4);
//
//        ArrayList<Assento> lA = new ArrayList<>();
//        lA.add(assento);
//        lA.add(assento2);
//        lA.add(assento3);
//        lA.add(assento4);
//
//        sala.setAssentos(lA);
//        em.persist(sala);
//        em.persist(sala2);
//
//        Sessao s = new Sessao(1, "SessaoTeste", new Date(), f, sala);
//        em.persist(s);
//
//        Thread.sleep(3);
//        Sessao s2 = new Sessao(2, "SessaoTeste2", new Date(), f, sala);
//
//        TipoIngresso ti = new TipoIngresso(1, "Inteira", 30);
//
//        Ingresso ing = new Ingresso(s, assento, new Date(), ti);
//        em.persist(ing);
//
//        Ingresso ing2 = new Ingresso(s2, assento, new Date(), ti);
//        em.persist(ing2);
//
//        em.getTransaction().commit();

//        em.getTransaction().begin();
//        UsuarioComum usuario = new UsuarioComum(1, "Noob", "noob", "12345");
//        em.persist(usuario);
//        em.getTransaction().commit();
    
//        ControleSessao cs = new ControleSessao();
//        
//        List<Sessao> ls = cs.localizarSessao(sala, new Date(), new Date());
//        
//        for(Sessao ss: ls){
//            System.out.println(ss);
//        }
//        
//        System.out.println(new Date());
        
        em.getTransaction().begin();
        Produto p = new Produto();
        p.setCodigo(1);
        p.setDescricao("Diamante Negro");
        p.setEstoque(100);
        p.setPreco(5);
        em.persist(p);
        em.getTransaction().commit();

    }
}
