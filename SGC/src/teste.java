
import br.edu.ifsp.pep.modelo.Filme;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class teste {
    
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("SGCPU");
        EntityManager em = emf.createEntityManager();
        System.out.println("Teste");
        Filme f = new Filme(2, "ADWo", "TIT", null, 200, "FODA", 16);
        System.out.println("Teste");
//        em.persist(f);
        System.out.println("TEste");
    }
}
