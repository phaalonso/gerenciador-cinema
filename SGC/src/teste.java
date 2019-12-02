
import br.edu.ifsp.pep.controle.ControleSessao;
import br.edu.ifsp.pep.modelo.Assento;
import br.edu.ifsp.pep.modelo.Filme;
import br.edu.ifsp.pep.modelo.Ingresso;
import br.edu.ifsp.pep.modelo.Sala;
import br.edu.ifsp.pep.modelo.Sessao;
import br.edu.ifsp.pep.modelo.TipoIngresso;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class teste {

    public static void main(String[] args) throws InterruptedException, ParseException {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("SGCPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Filme f3  = new Filme("a", "a", new Date(), 180, "a", 16);
        Filme f6  = new Filme("b", "b", new Date(), 360, "b", 16);
        Filme f12 = new Filme("c", "c", new Date(), 720, "c", 16);
        em.persist(f3);
        em.persist(f6);
        em.persist(f12);
        em.getTransaction().commit();
        Sala sala = new Sala(true, 1);
        //Assento assento = new Assento(new CodigoAssento(sala, "a01"), true);
        //Assento assento2 = new Assento(new CodigoAssento(sala, "a02"), true);
//        Assento assento = new Assento("a01", sala, true);
//        Assento assento2 = new Assento("a02", sala, true);
//        Assento assento3 = new Assento("a01", sala2, true);
//        Assento assento4 = new Assento("a02", sala2, true);

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Sessao s1 = new Sessao("a", sdf.parse("2019-11-19 00:00:00"), f12, sala);
        Sessao s2 = new Sessao("b", sdf.parse("2019-11-20 18:00:00"), f6, sala);
        Sessao s3 = new Sessao("c", sdf.parse("2019-11-21 06:00:00"), f6, sala);
        
////        em.getTransaction().begin();
////        em.persist(s1);
////        em.persist(s2);
////        em.persist(s3);
////        em.persist(sala);
////        em.persist(f3);
////        em.persist(f6);
////        em.persist(f12);
////        em.getTransaction().commit();

//        TipoIngresso ti = new TipoIngresso(1, "Inteira", 30);

//        Ingresso ing = new Ingresso(s, assento, new Date(), ti);
//        em.persist(ing);
//
//        Ingresso ing2 = new Ingresso(s2, assento, new Date(), ti);
//        em.persist(ing2);

        

//        em.getTransaction().begin();
//        UsuarioComum usuario = new UsuarioComum(1, "Noob", "noob", "12345");
//        em.persist(usuario);
//        em.getTransaction().commit();

        ControleSessao cs = new ControleSessao();

        List<Sessao> ls = cs.localizarConflito(sala, sdf.parse("2019-11-19 13:00:00"), sdf.parse("2019-11-21 17:00:00"));
        if(ls.isEmpty())
            System.out.println("Não encontrou nenhuma sessão!");
        else{
            System.out.println("Existe sessões!");
            for(Sessao ss: ls){
                System.out.println(ss);
            }
        }
    }
}
