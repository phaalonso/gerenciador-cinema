/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.modelo;

import javax.persistence.Entity;

/**
 *
 * @author Aluno
 */
@Entity
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
