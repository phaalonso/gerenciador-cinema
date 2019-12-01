
import br.edu.ifsp.pep.relatorio.GerarRelatorio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class testeRelatorio {
    public static void main(String[] args) throws ParseException, InterruptedException {
        EntityManager em = Persistence.createEntityManagerFactory("SGCPU").createEntityManager();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataInicial = sdf.parse("2019-01-01");
        Date dataFinal = sdf.parse("2019-01-02");
        new GerarRelatorio().gerarVendaProduto(em, "RelatorioProduto.jasper", dataInicial, dataFinal);
        Thread.currentThread().sleep(200);
        dataInicial = sdf.parse("2019-11-01");
        dataFinal = sdf.parse("2019-11-01");
        new GerarRelatorio().gerarSessao(em, "RelatorioSessao.jasper", dataInicial, dataFinal);
    }
}
