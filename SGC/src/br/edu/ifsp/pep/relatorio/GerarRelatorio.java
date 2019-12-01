package br.edu.ifsp.pep.relatorio;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import javax.persistence.EntityManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;
import net.sf.jasperreports.view.JasperViewer;

public class GerarRelatorio {
    public void gerarVendaProduto(EntityManager em, String relatorio,
            Date dataInicial, Date dataFinal){
        
        try{
            // Parametros
            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put(
                    JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER,
                    em
            );
            parametros.put("dataInicial", dataInicial);
            parametros.put("dataFinal", dataFinal);

            // Carregar relatorio JA compilado
            InputStream jasper = getClass().getResourceAsStream(
                    "/br/edu/ifsp/pep/relatorio/" + relatorio);

            // Preencher com os valores do banco
            JasperPrint jp = JasperFillManager.fillReport(jasper, parametros);
            
            // Exibir
            JasperViewer jv = new JasperViewer(jp, true);
            jv.setVisible(true);
        }catch(JRException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void gerarSessao(EntityManager em, String relatorio,
            Date dataInicial, Date dataFinal){
        try{
            // Parametros
            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put(
                    JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER,
                    em
            );
            parametros.put("dataInicial", dataInicial);
            parametros.put("dataFinal", dataFinal);
            
            // Carregar o relatório
            InputStream jasper = getClass().getResourceAsStream(
                    "/br/edu/ifsp/pep/relatorio/" + relatorio);
            
            // Preencher com os dados
            JasperPrint jp = JasperFillManager.fillReport(jasper, parametros);
            
            // Exibir
            JasperViewer jv = new JasperViewer(jp, true);
            jv.setVisible(true);
        }catch(JRException ex){
            System.err.println(ex.getMessage());
        }
    }
}
