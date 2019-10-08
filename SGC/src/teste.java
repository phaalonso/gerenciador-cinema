
import br.edu.ifsp.pep.modelo.Filme;
import br.edu.ifsp.pep.modelo.Genero;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class teste {
    
    public static void main(String[] args) {
        EntityManager em =
                Persistence.createEntityManagerFactory("SGCPU")
                        .createEntityManager();
        
        Genero g = new Genero();
        g.setCodigo(4);
        g.setDescricao("ação");
        
        Filme f = new Filme();
        f.setCodigo(123);
        f.setTitulo("Aloha");
        f.setDataEstreia(new Date());
        f.setDirecao("Carlos");
        f.setDuracao(120);
        f.setIdadeMinima(13);
        List<Genero> lista = new ArrayList<>();
        lista.add(g);
        f.setGeneros(lista);
        
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
    }
}
