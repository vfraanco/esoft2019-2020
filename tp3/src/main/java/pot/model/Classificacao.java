package pot.model;

import autorizacao.model.ListaClassificacoes;

public class Classificacao implements Comparable<Classificacao> {

    private int resultado;
    private Candidatura candidatura;
    private ListaClassificacoes listaClassificacoes;

    public Classificacao(int resultado, Candidatura candidatura) {
        this.resultado = resultado;
        this.candidatura = candidatura;
    }

    public int getResultado() {
        return resultado;
    }

    public int compareTo(Classificacao cla) {
        float resultado = this.resultado;
        float resultado1 = cla.getResultado();
        if (resultado < resultado1) {
            return -1;
        }
        if (resultado > resultado1) {
            return 1;
        }
        return 0;
    }

    public ListaClassificacoes getListaClassificacoes() {
        return listaClassificacoes;
    }
}