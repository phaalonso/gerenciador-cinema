package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="usuario_comum", uniqueConstraints = @UniqueConstraint(
        name = "uniqueLogin", columnNames = "login"
))
@DiscriminatorColumn(name = "tipo")
@DiscriminatorValue(value = "comum")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
    @NamedQuery(name = "UsuarioComum.findAll", query = "SELECT U FROM UsuarioComum U"),
    @NamedQuery(name = "UsuarioComum.login", query = "SELECT U FROM UsuarioComum U"
            + " WHERE U.login = :login AND U.senha = :senha")
})
public class UsuarioComum implements Serializable{
    @Id
    @Column(name = "codigo")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Column(name = "login", length = 20, nullable = false)
    private String login;
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;

    public UsuarioComum() {
    }

    public UsuarioComum(Integer codigo, String nome, String login, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "UsuarioComum{" + "codigo=" + codigo + ", nome=" + nome + ", login=" + login + ", senha=" + senha + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.codigo);
        hash = 23 * hash + Objects.hashCode(this.login);
        hash = 23 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioComum other = (UsuarioComum) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    
    
}
