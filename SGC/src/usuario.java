
import br.edu.ifsp.pep.controle.ControleUsuario;
import br.edu.ifsp.pep.modelo.UsuarioComum;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pedro
 */
public class usuario {
    public static void main(String[] args) {
        ControleUsuario cu = new ControleUsuario();
        
        UsuarioComum usuario = new UsuarioComum(1,"Pedro","phaalonso","1234");
        cu.persist(usuario);
    }
}
