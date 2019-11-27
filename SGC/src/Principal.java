
import br.edu.ifsp.pep.controle.ControleTipoIngresso;
import br.edu.ifsp.pep.controle.ControleUsuario;
import br.edu.ifsp.pep.modelo.TipoIngresso;
import br.edu.ifsp.pep.modelo.TipoUsuario;
import br.edu.ifsp.pep.modelo.Usuario;
import br.edu.ifsp.pep.visao.Login;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        ControleTipoIngresso controleTipoIngresso = new ControleTipoIngresso();
        ControleUsuario controleUsuario = new ControleUsuario();
        List<TipoIngresso> listaTipoIngresso;
        List<Usuario> listaUsuario;
        
        // Seria bom colocar alguma tela indicando "inicializando" aqui
        
        // Verificação inicial, é obrigatório ter um super usuário padrão,
        // um ingresso do tipo inteira e um ingresso do tipo meia
        listaTipoIngresso = controleTipoIngresso.findAll();
        if(listaTipoIngresso.isEmpty()){
            controleTipoIngresso.merge(new TipoIngresso("Inteira", 20));
            controleTipoIngresso.merge(new TipoIngresso("Meia", 10));
        }
        listaUsuario = controleUsuario.findAll();
        if(listaUsuario.isEmpty())
            controleUsuario.merge(new Usuario("admin", "admin", 
                "password", TipoUsuario.SUPER));
        
        listaTipoIngresso = null;
        listaUsuario = null;
        
        // Dar dispose da tela de carregamento
        // a
        
        Login telaLogin = new Login();
        telaLogin.setVisible(true);
    }
}
