package br.edu.ifsp.pep.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "super_usuario")
@DiscriminatorValue(value = "super")
public class SuperUsuario extends UsuarioComum{

    public SuperUsuario() {
    }
    
    public SuperUsuario(Integer codigo, String nome, String login, String senha) {
        super(codigo, nome, login, senha);
    }

    @Override
    public String toString() {
        return "SuperUsuario{ codigo: " + this.getCodigo()+ ", nome: " +this.getLogin() + ", senha: " +this.getSenha() + '}';
    }   
    
}
