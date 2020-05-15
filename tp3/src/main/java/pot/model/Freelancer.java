package pot.model;

import java.util.HashSet;
import java.util.Set;

public class Freelancer {

    private String nome, email;
    private int NIF, telefone;

    public Freelancer(String nome, int NIF, int telefone, String email) {
        this.nome = nome;
        this.NIF = NIF;
        this.telefone = telefone;
        this.email = email;
    }
    
    public String getNome(){
        return nome;
    }

    public int getNIF(){
        return NIF;
    }

    public int getTelefone(){
        return telefone;
    }

    public String getEmail(){
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Freelancer{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", NIF=" + NIF +
                ", telefone=" + telefone +
                '}';
    }
}