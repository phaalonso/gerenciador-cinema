
import br.edu.ifsp.pep.relatorio.GerarRelatorio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class testeRelatorio {
    public static void main(String[] args) throws ParseException {
        EntityManager em = Persistence.createEntityManagerFactory("SGCPU").createEntityManager();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataInicial = sdf.parse("2019-01-01");
        Date dataFinal = sdf.parse("2019-01-02");
        new GerarRelatorio().gerarVendaProduto(em, "RelatorioProduto.jasper", dataInicial, dataFinal);
    }
}
