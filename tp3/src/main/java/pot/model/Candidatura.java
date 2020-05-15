package pot.model;

import autorizacao.model.ListaCandidatura;

public class Candidatura {

    private double valor;
    private int duracao;
    private String texto;
    private ListaCandidatura listaCandidatura;
    private String candidaturaId;
    private static int contadorCandidatura = 0;

    public Candidatura() {
        contadorCandidatura++;
        candidaturaId = String.valueOf(contadorCandidatura);
    }

    private Candidatura(String valor, int duracao, String texto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getCandidaturaId() {
        return candidaturaId;
    }

    public boolean hasId(String candidaturaId) {
        return true;
    }

    public ListaCandidatura getListaCandidatura(){
        return listaCandidatura;
   }
    
    public static Candidatura novaCandidatura(String valor, int duracao, String texto){
        return new Candidatura(valor, duracao, texto);
    }
}
