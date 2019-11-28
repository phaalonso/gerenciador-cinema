import br.edu.ifsp.pep.controle.ControleUsuario;
import br.edu.ifsp.pep.modelo.TipoUsuario;
import br.edu.ifsp.pep.modelo.Usuario;
import br.edu.ifsp.pep.visao.Login;
import java.util.List;
import javax.persistence.Persistence;

public class Principal {
    public static void main(String[] args) {
        ControleUsuario controleUsuario = new ControleUsuario();
        List<Usuario> listaUsuario;
        
        // Seria bom colocar alguma tela indicando "inicializando" aqui
        
        // Verificação inicial, é obrigatório ter um super usuário padrão
        listaUsuario = controleUsuario.findAll();
        if(listaUsuario.isEmpty())
            controleUsuario.merge(new Usuario("admin", "admin", 
                "password", TipoUsuario.SUPER));
        
        listaUsuario = null;
        
        // Dar dispose da tela de carregamento
        
        Login telaLogin = new Login();
        telaLogin.setVisible(true);
    }
}
