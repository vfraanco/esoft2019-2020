package autorizacao.model;

import pot.model.Candidatura;
import pot.model.Classificacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaClassificacoes {

    private List<Classificacao> listaClassificacoes = new ArrayList<Classificacao>();

    public Classificacao novaClassificacao(int resultado, Candidatura candidatura){
        return new Classificacao(resultado, candidatura);
    }

    public boolean add(Classificacao c) {
        listaClassificacoes.add(c);
        return true;
    }
    public Classificacao get(int index) {
        return listaClassificacoes.get(index);
    }

    public List<Classificacao> getListaClassificacoes() {
        return listaClassificacoes;
    }

    public List<Classificacao>  ordenaClassificacoes(){
        List<Classificacao> listaOrdenada = listaClassificacoes;
        Collections.sort(listaOrdenada);
        return listaOrdenada;
    }

    public boolean validaClassificacao(Classificacao classificacao) {
        if (classificacao == null) {
            return false;
        }
        for (Classificacao clas : listaClassificacoes) {
            if (clas.equals(classificacao)) {
                return false;
            }
        }
        return true;
    }
}
